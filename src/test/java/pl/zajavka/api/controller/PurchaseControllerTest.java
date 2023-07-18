package pl.zajavka.api.controller;

import lombok.AllArgsConstructor;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import pl.zajavka.api.dto.CarPurchaseDTO;
import pl.zajavka.api.dto.mapper.CarMapper;
import pl.zajavka.api.dto.mapper.CarPurchaseMapper;
import pl.zajavka.business.CarPurchaseService;
import pl.zajavka.domain.Invoice;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(controllers = PurchaseController.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
class PurchaseControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private CarPurchaseService carPurchaseService;

    @MockBean
    private CarPurchaseMapper carPurchaseMapper;

    @MockBean
    private CarMapper carMapper;

    @Test
    void carPurchaseWorksCorrectly() throws Exception {
//        given
        LinkedMultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        CarPurchaseDTO.buildDefaultData().asMap().forEach(parameters::add);

        Invoice expectedInvoice = Invoice.builder().invoiceNumber("test").build();
        Mockito.when(carPurchaseService.purchase(Mockito.any())).thenReturn(expectedInvoice);
//        when, then
        mockMvc.perform(MockMvcRequestBuilders.post("/purchase").params(parameters))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("invoiceNumber"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customerName"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customerSurname"))
                .andExpect(MockMvcResultMatchers.view().name("car_purchase_done"));
    }

    @Test
    void thatEmailValidationWorksCorrectly() throws Exception {
//        given
        LinkedMultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        Map<String, String> parametersMap = CarPurchaseDTO.buildDefaultData().asMap();
        parametersMap.put("customerEmail", "badEmail");
        parametersMap.forEach(parameters::add);

//        when, then
        mockMvc.perform(MockMvcRequestBuilders.post("/purchase").params(parameters))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.model().attributeExists("errorMessage"))
                .andExpect(MockMvcResultMatchers.model().attribute("errorMessage", Matchers.containsString("badEmail")))
                .andExpect(MockMvcResultMatchers.view().name("error"));

    }

    @ParameterizedTest
    @MethodSource
    void thatPhoneValidationWorksCorrectly(Boolean correctPhone, String phone) throws Exception {
//        given
        LinkedMultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        Map<String, String> parametersMap = CarPurchaseDTO.buildDefaultData().asMap();
        parametersMap.put("customerPhone", phone);
        parametersMap.forEach(parameters::add);

//        when,then
        if (correctPhone) {
            Invoice expectedInvoice = Invoice.builder().invoiceNumber("test").build();
            Mockito.when(carPurchaseService.purchase(Mockito.any())).thenReturn(expectedInvoice);

            mockMvc.perform(MockMvcRequestBuilders.post("/purchase").params(parameters))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.model().attributeExists("invoiceNumber"))
                    .andExpect(MockMvcResultMatchers.model().attributeExists("customerName"))
                    .andExpect(MockMvcResultMatchers.model().attributeExists("customerSurname"))
                    .andExpect(MockMvcResultMatchers.view().name("car_purchase_done"));
        } else {
            mockMvc.perform(MockMvcRequestBuilders.post("/purchase").params(parameters))
                    .andExpect(MockMvcResultMatchers.status().isBadRequest())
                    .andExpect(MockMvcResultMatchers.model().attributeExists("errorMessage"))
                    .andExpect(MockMvcResultMatchers.model().attribute("errorMessage", Matchers.containsString(phone)))
                    .andExpect(MockMvcResultMatchers.view().name("error"));
        }
    }

    public static Stream<Arguments> thatPhoneValidationWorksCorrectly() {
        return Stream.of(
                Arguments.of(false, ""),
                Arguments.of(false, "+48 504 203 260@@"),
                Arguments.of(false, "+48.504.203.260"),
                Arguments.of(false, "+55(123) 456-78-90-"),
                Arguments.of(false, "+55(123) - 456-78-90"),
                Arguments.of(false, "504.203.260"),
                Arguments.of(false, " "),
                Arguments.of(false, "-"),
                Arguments.of(false, "()"),
                Arguments.of(false, "() + ()"),
                Arguments.of(false, "(21 7777"),
                Arguments.of(false, "+48 (21)"),
                Arguments.of(false, "+"),
                Arguments.of(false, " 1"),
                Arguments.of(false, "1"),
                Arguments.of(false, "555-5555-555"),
                Arguments.of(false, "+48 (12) 504 203 260"),
                Arguments.of(false, "+48 (12) 504-203-260"),
                Arguments.of(false, "+48(12)504203260"),
                Arguments.of(false, "+4812504203260"),
                Arguments.of(false, "4812504203260"),
                Arguments.of(true, "+48 504 203 260")
        );
    }
}
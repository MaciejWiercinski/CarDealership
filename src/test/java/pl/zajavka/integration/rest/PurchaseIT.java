package pl.zajavka.integration.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.zajavka.api.dto.CarPurchaseDTO;
import pl.zajavka.api.dto.CarsToBuyDTO;
import pl.zajavka.api.dto.InvoiceDTO;
import pl.zajavka.integration.configuration.RestAssuredIntegrationTestBase;
import pl.zajavka.integration.support.PurchaseControllerTestSupport;

import java.util.ArrayList;

public class PurchaseIT extends RestAssuredIntegrationTestBase implements PurchaseControllerTestSupport {

    @Test
    void thatCarPurchaseWorksCorrectly() {
//        given
        CarsToBuyDTO carsToBuyDTO = findAvailableCars();
        CarPurchaseDTO carPurchaseDTO = someCarPurchaseDTO();

//        when
        InvoiceDTO invoiceDTO = purchaseCar(carPurchaseDTO);

//        then
        CarsToBuyDTO carsToBuyDTOAfterPurchase = findAvailableCars();

        Assertions.assertThat(invoiceDTO.getInvoiceNumber()).isNotNull();
        Assertions.assertThat(invoiceDTO.getDateTime()).isNotNull();
        var carsToBuyBeforePurchse = new ArrayList<>(carsToBuyDTO.getCarsToBuy());
        var carsToBuyAfterPurchase = new ArrayList<>(carsToBuyDTOAfterPurchase.getCarsToBuy());
        carsToBuyBeforePurchse.removeAll(carsToBuyAfterPurchase);
        Assertions.assertThat(carsToBuyBeforePurchse).hasSize(1);
        Assertions.assertThat(carsToBuyBeforePurchse.get(0).getVin()).isEqualTo(carPurchaseDTO.getCarVin());
    }

    public static CarPurchaseDTO someCarPurchaseDTO() {
        return CarPurchaseDTO.buildDefaultData()
                .withCarVin("1FT7X2B60FEA74019")
                .withSalesmanPesel("73021314515");
    }
}

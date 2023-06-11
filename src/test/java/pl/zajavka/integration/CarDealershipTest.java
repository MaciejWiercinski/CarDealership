package pl.zajavka.integration;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import pl.zajavka.business.CarPurchaseService;
import pl.zajavka.business.CarService;
import pl.zajavka.business.CarServiceProcessingService;
import pl.zajavka.business.CarServiceRequestService;
import pl.zajavka.infrastructure.configuration.ApplicationConfiguration;
import pl.zajavka.infrastructure.database.entity.CarServiceRequestEntity;
import pl.zajavka.infrastructure.database.entity.ServiceMechanicEntity;
import pl.zajavka.infrastructure.database.entity.ServicePartEntity;
import pl.zajavka.infrastructure.database.repository.jpa.CarServiceRequestJpaRepository;
import pl.zajavka.infrastructure.database.repository.jpa.InvoiceJpaRepository;
import pl.zajavka.infrastructure.database.repository.jpa.ServiceMechanicJpaRepository;
import pl.zajavka.infrastructure.database.repository.jpa.ServicePartJpaRepository;

import java.util.List;
import java.util.Objects;

@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringJUnitConfig(classes = {ApplicationConfiguration.class})
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CarDealershipTest {

    private CarPurchaseService carPurchaseService;
    private CarServiceRequestService carServiceRequestService;
    private CarServiceProcessingService carServiceProcessingService;
    private CarService carService;

    private final InvoiceJpaRepository invoiceJpaRepository;
    private final CarServiceRequestJpaRepository carServiceRequestJpaRepository;
    private final ServiceMechanicJpaRepository serviceMechanicJpaRepository;
    private final ServicePartJpaRepository servicePartJpaRepository;

    @Test
    @Order(1)
    void purchase() {
        log.info("### RUNNING ORDER 3");
        carPurchaseService.purchase();
    }

    @Test
    @Order(2)
    void makeServiceRequests() {
        log.info("### RUNNING ORDER 4");
        carServiceRequestService.requestService();
    }

    @Test
    @Order(3)
    void processServiceRequests() {
        log.info("### RUNNING ORDER 5");
        carServiceProcessingService.process();
    }

    @Test
    @Order(4)
    void printCarHistory() {
        log.info("### RUNNING ORDER 6");
        carService.printCarHistory("2C3CDYAG2DH731952");
        carService.printCarHistory("1GCEC19X27Z109567");
    }

    @Test
    @Order(5)
    void verify() {
        Assertions.assertEquals(6, invoiceJpaRepository.findAll().size());

        List<CarServiceRequestEntity> allServiceRequests = carServiceRequestJpaRepository.findAll();
        Assertions.assertEquals(3, allServiceRequests.size());
        Assertions.assertEquals(2, allServiceRequests.stream().filter(sr -> Objects.nonNull(sr.getCompletedDateTime())).count());

        List<ServiceMechanicEntity> allServiceMechanics = serviceMechanicJpaRepository.findAll();
        Assertions.assertEquals(5, allServiceMechanics.size());

        List<ServicePartEntity> allServiceParts = servicePartJpaRepository.findAll();
        Assertions.assertEquals(4, allServiceParts.size());
    }
}

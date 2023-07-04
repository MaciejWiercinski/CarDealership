package pl.zajavka.business;

import lombok.AllArgsConstructor;
import pl.zajavka.domain.CarToBuy;
import pl.zajavka.domain.Salesman;

import java.util.List;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class CarPurchaseService {

    private final CarService carService;
    private final SalesmanService salesmanService;

    //
    //    private final FileDataPreparationService fileDataPreparationService;
    //    private final CustomerService customerService;
    public List<CarToBuy> availableCars() {
        return carService.findAvailableCars();
    }

    public List<Salesman> availableSalesman() {
        return salesmanService.findAvailable();
    }
//
//    public void purchase() {
//        var firstTimeData = fileDataPreparationService.prepareFirstTimePurchaseData();
//        var nextTimeData = fileDataPreparationService.prepareNextTimePurchaseData();
//
//        List<Customer> firstTimeCustomers = firstTimeData.stream()
//                .map(this::createFirstTimeToBuyCustomer)
//                .toList();
//        firstTimeCustomers.forEach(customerService::issueInvoice);
//
//        List<Customer> nextTimeCustomers = nextTimeData.stream()
//                .map(this::createNextTimeToBuyCustomer)
//                .toList();
//        nextTimeCustomers.forEach(customerService::issueInvoice);
//    }
//
//    private Customer createFirstTimeToBuyCustomer(CarPurchaseRequestInputData inputData) {
//        CarToBuy car = carService.findCarToBuy(inputData.getCarVin());
//        Salesman salesman = salesmanService.findSalesman(inputData.getSalesmanPesel());
//        Invoice invoice = buildInvoice(car, salesman);
//
//        return fileDataPreparationService.buildCustomer(inputData, invoice);
//    }
//
//
//    private Customer createNextTimeToBuyCustomer(CarPurchaseRequestInputData inputData) {
//        Customer existingCustomer = customerService.findCustomer(inputData.getCustomerEmail());
//        CarToBuy car = carService.findCarToBuy(inputData.getCarVin());
//        Salesman salesman = salesmanService.findSalesman(inputData.getSalesmanPesel());
//        Invoice invoice = buildInvoice(car, salesman);
//        Set<Invoice> existingInvoices = existingCustomer.getInvoices();
//        existingInvoices.add(invoice);
//        return existingCustomer.withInvoices(existingInvoices);
//    }
//
//    private Invoice buildInvoice(CarToBuy car, Salesman salesman) {
//        return Invoice.builder()
//                .invoiceNumber(UUID.randomUUID().toString())
//                .dateTime(OffsetDateTime.now())
//                .car(car)
//                .salesman(salesman)
//                .build();
//    }
}

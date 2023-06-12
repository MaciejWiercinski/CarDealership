package pl.zajavka.domain;

import lombok.*;

import java.time.OffsetDateTime;

@Builder
@With
@Value
@EqualsAndHashCode(of = "invoiceNumber")
@ToString(of = {"invoiceId", "invoiceNumber", "dateTime"})
public class Invoice {

    Integer invoiceId;
    String invoiceNumber;
    OffsetDateTime dateTime;
    CarToBuy car;
    Customer customer;
    Salesman salesman;

}


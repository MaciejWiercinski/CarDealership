package pl.zajavka.util;

import lombok.experimental.UtilityClass;
import pl.zajavka.domain.CarToService;
import pl.zajavka.infrastructure.database.entity.CarToBuyEntity;
import pl.zajavka.infrastructure.database.entity.CarToServiceEntity;

import java.math.BigDecimal;

@UtilityClass
public class EntityFixtures {

    public static CarToBuyEntity someCar1() {
        return CarToBuyEntity.builder()
                .vin("vin1")
                .brand("brand1")
                .model("model1")
                .year(2000)
                .color("color1")
                .price(new BigDecimal("1010.20"))
                .build();
    }
    public static CarToBuyEntity someCar2() {
        return CarToBuyEntity.builder()
                .vin("vin2")
                .brand("brand2")
                .model("model2")
                .year(2000)
                .color("color2")
                .price(new BigDecimal("2010.20"))
                .build();
    }
    public static CarToBuyEntity someCar3() {
        return CarToBuyEntity.builder()
                .vin("vin3")
                .brand("brand3")
                .model("model3")
                .year(2000)
                .color("color3")
                .price(new BigDecimal("3010.20"))
                .build();
    }

    public static CarToServiceEntity someCarToService1() {
        return CarToServiceEntity.builder()
                .vin("vin4")
                .brand("brand4")
                .model("model4")
                .year(2004)
                .build();
    }

    public static CarToServiceEntity someCarToService2() {
        return CarToServiceEntity.builder()
                .vin("vin5")
                .brand("brand5")
                .model("model5")
                .year(2005)
                .build();
    }
}

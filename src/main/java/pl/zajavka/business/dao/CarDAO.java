package pl.zajavka.business.dao;

import pl.zajavka.domain.CarHistory;
import pl.zajavka.domain.CarToBuy;
import pl.zajavka.domain.CarToService;

import java.util.Optional;

public interface CarDAO {
    Optional<CarToService> findCarToServiceByVin(String vin);

    Optional<CarToBuy> findCarToBuyByVin(String vin);

    CarToService  saveCarToService(CarToService   );

    CarHistory findCarHistoryByVin(String vin);
}

package pl.zajavka.business.dao;

import pl.zajavka.infrastructure.database.entity.CarToBuyEntity;
import pl.zajavka.infrastructure.database.entity.CarToServiceEntity;

import java.util.Optional;

public interface CarDAO {
    Optional<CarToServiceEntity> findCarToServiceByVin(String vin);

    Optional<CarToBuyEntity> findCarToBuyByVin(String vin);

    CarToServiceEntity saveCarToService(CarToServiceEntity entity);
}

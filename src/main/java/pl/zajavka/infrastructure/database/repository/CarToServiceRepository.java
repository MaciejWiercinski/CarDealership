package pl.zajavka.infrastructure.database.repository;

import pl.zajavka.business.dao.CarToServiceDAO;
import pl.zajavka.domain.CarHistory;
import pl.zajavka.domain.CarToService;

import java.util.Optional;

public class CarToServiceRepository implements CarToServiceDAO {
    @Override
    public Optional<CarToService> findCarToServiceByVin(String vin) {
        return Optional.empty();
    }

    @Override
    public CarToService saveCarToService(CarToService carToService) {
        return null;
    }

    @Override
    public CarHistory findCarHistoryByVin(String vin) {
        return null;
    }
}

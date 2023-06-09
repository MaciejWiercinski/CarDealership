package pl.zajavka.infrastructure.database.repository;

import pl.zajavka.business.dao.CarToBuyDAO;
import pl.zajavka.domain.CarToBuy;

import java.util.Optional;

public class CarToBuyRepository implements CarToBuyDAO {
    @Override
    public Optional<CarToBuy> findCarToBuyByVin(String vin) {
        return Optional.empty();
    }
}

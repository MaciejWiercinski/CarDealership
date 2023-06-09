package pl.zajavka.infrastructure.database.repository;

import org.hibernate.Session;
import pl.zajavka.business.dao.MechanicDAO;
import pl.zajavka.domain.Mechanic;
import pl.zajavka.infrastructure.database.entity.MechanicEntity;

import java.util.Objects;
import java.util.Optional;

public class MechanicRepository implements MechanicDAO {
    @Override
    public Optional<Mechanic> findByPesel(String pesel) {

    }
}

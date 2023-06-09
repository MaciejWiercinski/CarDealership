package pl.zajavka.infrastructure.database.repository;

import org.hibernate.Session;
import pl.zajavka.business.dao.SalesmanDAO;
import pl.zajavka.domain.Salesman;
import pl.zajavka.infrastructure.database.entity.SalesmanEntity;

import java.util.Objects;
import java.util.Optional;

public class SalesmanRepository implements SalesmanDAO {
    @Override
    public Optional<Salesman> findByPesel(String pesel) {

}

package pl.zajavka.infrastructure.database.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pl.zajavka.business.dao.ServiceDAO;
import pl.zajavka.domain.Service;
import pl.zajavka.infrastructure.database.entity.ServiceEntity;

import java.util.Objects;
import java.util.Optional;

public class ServiceRepository implements ServiceDAO {
    @Override
    public Optional<Service> findByServiceCode(String serviceCode) {

    }
}

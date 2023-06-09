package pl.zajavka.infrastructure.database.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pl.zajavka.business.dao.PartDAO;
import pl.zajavka.domain.Part;
import pl.zajavka.infrastructure.database.entity.PartEntity;

import java.util.Objects;
import java.util.Optional;

public class PartRepository implements PartDAO {
    @Override
    public Optional<Part> findBySerialNumber(String serialNumber) {

    }
}

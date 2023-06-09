package pl.zajavka.infrastructure.database.repository;

import org.hibernate.Session;
import pl.zajavka.business.dao.CarServiceRequestDAO;
import pl.zajavka.domain.CarServiceRequest;
import pl.zajavka.infrastructure.database.entity.CarServiceRequestEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class CarServiceRequestRepository implements CarServiceRequestDAO {
    @Override
    public Set<CarServiceRequest> findActiveServiceRequestsByCarVin(String carVin) {
        return null;
        }
    }
}

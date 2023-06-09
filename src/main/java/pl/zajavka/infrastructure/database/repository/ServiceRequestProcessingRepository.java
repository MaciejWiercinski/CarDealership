package pl.zajavka.infrastructure.database.repository;

import org.hibernate.Session;
import pl.zajavka.business.dao.ServiceRequestProcessingDAO;
import pl.zajavka.domain.CarServiceRequest;
import pl.zajavka.domain.ServiceMechanic;
import pl.zajavka.infrastructure.database.entity.CarServiceRequestEntity;
import pl.zajavka.infrastructure.database.entity.ServiceMechanicEntity;
import pl.zajavka.infrastructure.database.entity.ServicePartEntity;

import java.util.Objects;

public class ServiceRequestProcessingRepository implements ServiceRequestProcessingDAO {
    @Override
    public void process(
            CarServiceRequest serviceRequest,
            ServiceMechanic serviceMechanic
    )
    }

    @Override
    public void process(
            CarServiceRequest serviceRequest,
            ServiceMechanic serviceMechanic,
            ServicePartEntity servicePartEntity
    ) {

    }
}

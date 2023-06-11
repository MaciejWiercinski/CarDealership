package pl.zajavka.business;

import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import pl.zajavka.business.dao.ServiceDAO;
import pl.zajavka.domain.Service;

import java.util.Optional;

@AllArgsConstructor
public class ServiceCatalogService {

    private final ServiceDAO serviceDAO;

    @Transactional
    public Service findService(String serviceCode) {
        Optional<Service> service = serviceDAO.findByServiceCode(serviceCode);
        if (service.isEmpty()) {
            throw new RuntimeException("Could not find service by serviceCode: [%s]".formatted(serviceCode));
        }
        return service.get();
    }

}

package pl.zajavka.business.dao;

import pl.zajavka.domain.Part;

import java.util.List;
import java.util.Optional;

public interface PartDAO {


     List<Part> findAll();

    Optional<Part> findBySerialNumber(String serviceNumber);
}

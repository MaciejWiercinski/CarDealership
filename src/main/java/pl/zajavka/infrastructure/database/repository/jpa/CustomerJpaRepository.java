package pl.zajavka.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zajavka.infrastructure.database.entity.CustomerEntity;

import java.util.HashSet;
import java.util.Objects;


@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Integer> {


}

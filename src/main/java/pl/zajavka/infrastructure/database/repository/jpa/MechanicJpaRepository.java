package pl.zajavka.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zajavka.infrastructure.database.repository.MechanicRepository;

@Repository
public interface MechanicJpaRepository extends JpaRepository<MechanicRepository, Integer> {



}

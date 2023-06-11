package pl.zajavka.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zajavka.infrastructure.database.entity.MechanicEntity;
import pl.zajavka.infrastructure.database.repository.MechanicRepository;

import java.util.Optional;

@Repository
public interface MechanicJpaRepository extends JpaRepository<MechanicEntity, Integer> {


    Optional<MechanicEntity> findByPesel(String pesel);
}

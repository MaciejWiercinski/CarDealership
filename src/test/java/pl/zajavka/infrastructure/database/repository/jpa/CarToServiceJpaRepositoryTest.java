package pl.zajavka.infrastructure.database.repository.jpa;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import pl.zajavka.infrastructure.database.entity.CarToServiceEntity;
import pl.zajavka.integration.configuration.PersistenceContainerTestConfiguration;
import pl.zajavka.util.EntityFixtures;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({PersistenceContainerTestConfiguration.class})
@AllArgsConstructor(onConstructor = @__(@Autowired))
class CarToServiceJpaRepositoryTest {

    private CarToServiceJpaRepository carToServiceJpaRepository;

    @Test
    void thatCarCanBeSavedCorrectly() {
//        given
        List<CarToServiceEntity> carsToService = List.of(EntityFixtures.someCarToService1(), EntityFixtures.someCarToService2());

        carToServiceJpaRepository.saveAllAndFlush(carsToService);

//        when
        List<CarToServiceEntity> availableCars = carToServiceJpaRepository.findAll();

//        then
        assertThat(availableCars).hasSize(2);
    }

}
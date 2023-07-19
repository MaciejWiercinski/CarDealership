package pl.zajavka.infrastructure.database.repository.jpa;

import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import pl.zajavka.infrastructure.database.entity.CarToBuyEntity;
import pl.zajavka.integration.configuration.PersistenceContainerTestConfiguration;
import pl.zajavka.util.EntityFixtures;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({PersistenceContainerTestConfiguration.class})
@AllArgsConstructor(onConstructor = @__(@Autowired))
class CarToBuyJpaRepositoryTest {

    private CarToBuyJpaRepository carToBuyJpaRepository;

    @Test
    void thatCarCanBeSavedCorrectly() {
//        given
        var cars = List.of(EntityFixtures.someCar1(), EntityFixtures.someCar2(), EntityFixtures.someCar3());
        carToBuyJpaRepository.saveAllAndFlush(cars);

//        when
        List<CarToBuyEntity> availableCars = carToBuyJpaRepository.findAvailableCars();

//        then
        Assertions.assertThat(availableCars).hasSize(9);
    }

}
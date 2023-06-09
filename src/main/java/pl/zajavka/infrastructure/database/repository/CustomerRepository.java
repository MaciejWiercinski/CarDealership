package pl.zajavka.infrastructure.database.repository;

import org.hibernate.Session;
import pl.zajavka.business.dao.CustomerDAO;
import pl.zajavka.domain.Customer;
import pl.zajavka.infrastructure.database.entity.CustomerEntity;

import java.util.Objects;
import java.util.Optional;

public class CustomerRepository implements CustomerDAO {
    @Override
    public Optional<Customer> findByEmail(String email) {

    }

    @Override
    public void issueInvoice(Customer customer) {

    }

    @Override
    public void saveServiceRequest(Customer customer) {

    }

    @Override
    public Customer saveCustomer(Customer entity) {

    }
}

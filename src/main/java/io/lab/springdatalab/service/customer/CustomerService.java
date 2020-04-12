package io.lab.springdatalab.service.customer;

import io.lab.springdatalab.model.Customer;

import java.util.Optional;

public interface CustomerService {

    Iterable<Customer> getAllCustomers();

    Optional<Customer> getCustomer(long id);
}

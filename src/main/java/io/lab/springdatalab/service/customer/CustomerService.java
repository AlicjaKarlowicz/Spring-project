package io.lab.springdatalab.service.customer;

import com.github.fge.jsonpatch.JsonPatch;
import io.lab.springdatalab.model.Customer;

import java.util.Optional;

public interface CustomerService {

    Iterable<Customer> getAllCustomers();

    Customer getCustomer(long id);

    Customer saveCustomer(Customer customer);
}

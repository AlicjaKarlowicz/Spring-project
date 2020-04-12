package io.lab.springdatalab.service.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import io.lab.springdatalab.model.Customer;

import java.util.Optional;

public interface CustomerService {

    Iterable<Customer> getAllCustomers();

    Optional<Customer> getCustomer(long id);

    //Customer applyPatchToCustomer(JsonPatch patch, Customer targetCustomer) throws JsonPatchException, JsonProcessingException;
}

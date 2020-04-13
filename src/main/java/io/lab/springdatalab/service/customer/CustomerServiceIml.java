package io.lab.springdatalab.service.customer;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonpatch.JsonPatch;
import io.lab.springdatalab.exception.ResourceNotFound;
import io.lab.springdatalab.model.Customer;
import io.lab.springdatalab.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceIml implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Iterable<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Customer getCustomer(long id) {
        return customerRepo.findById(id).orElseThrow(ResourceNotFound::new);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepo.save(customer);
    }
}

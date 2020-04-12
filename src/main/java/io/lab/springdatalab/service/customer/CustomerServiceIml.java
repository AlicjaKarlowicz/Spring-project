package io.lab.springdatalab.service.customer;

import io.lab.springdatalab.model.Customer;
import io.lab.springdatalab.repository.CustomerRepo;
import io.lab.springdatalab.service.customer.CustomerService;
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
    public Optional<Customer> getCustomer(long id) {
        return customerRepo.findById(id);
    }
}

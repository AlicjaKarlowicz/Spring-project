package io.lab.springdatalab.controller;

import io.lab.springdatalab.model.Customer;
import io.lab.springdatalab.model.Product;
import io.lab.springdatalab.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value ="/all")
    public Iterable<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping
    public Optional<Customer> getCustomerById(@RequestParam Long id) {
        return customerService.getCustomer(id);
    }
}

package io.lab.springdatalab.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import io.lab.springdatalab.exception.ResourceNotFound;
import io.lab.springdatalab.model.Customer;
import io.lab.springdatalab.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Customer getCustomerById(@RequestParam Long id) {
        return customerService.getCustomer(id);
    }


}

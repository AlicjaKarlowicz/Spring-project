package io.lab.springdatalab.controller;

import com.github.fge.jsonpatch.JsonPatch;
import io.lab.springdatalab.model.Customer;
import io.lab.springdatalab.model.Product;
import io.lab.springdatalab.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

//    @PatchMapping(path = "/{id}", consumes = "application/json-patch+json")
//    public ResponseEntity<Customer> updateCustomer(@PathVariable String id, @RequestBody JsonPatch patch) {
//
//            Customer customer = customerService.findCustomer(id);
//            Customer customerPatched = applyPatchToCustomer(patch, customer);
//            customerService.updateCustomer(customerPatched);
//            return ResponseEntity.ok(customerPatched);
//    }
}

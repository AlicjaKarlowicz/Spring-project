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
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping(value ="/customer/all")
    public Iterable<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(value = "/customer")
    public Customer getCustomerById(@RequestParam Long id) {
        return customerService.getCustomer(id);
    }

    @PostMapping(value = "/admin/customer")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @PutMapping(value = "/admin/customer")
    public Customer updateCustomer(@RequestParam Long id, @RequestBody Customer customer) {
        Customer c = customerService.getCustomer(id);
        return customerService.saveCustomer(c);
    }

    @PatchMapping(value = "/admin/customer",consumes = "application/json-patch+json")
    public ResponseEntity<?> patchCustomer(@RequestParam Long id, @RequestBody JsonPatch patch) throws JsonPatchException, JsonProcessingException {

            Customer customer = customerService.getCustomer(id);
            Customer customerPatched = applyPatchToCustomer(patch, customer);
            customerService.saveCustomer(customerPatched);

            return ResponseEntity.ok(customerPatched);

    }

    private Customer applyPatchToCustomer(JsonPatch patch, Customer targetCustomer) throws JsonPatchException, JsonProcessingException {

        JsonNode patched = patch.apply(objectMapper.convertValue(targetCustomer, JsonNode.class));
        return objectMapper.treeToValue(patched, Customer.class);
    }
}

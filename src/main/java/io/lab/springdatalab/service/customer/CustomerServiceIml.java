package io.lab.springdatalab.service.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
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

//    @Override
//    public Customer applyPatchToCustomer(
//            JsonPatch patch, Customer targetCustomer) throws JsonPatchException, JsonProcessingException {
//        JsonNode patched = patch.apply(objectMapper.convertValue(targetCustomer, JsonNode.class));
//        return objectMapper.treeToValue(patched, Customer.class);
//    }
}

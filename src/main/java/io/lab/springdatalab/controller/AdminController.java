package io.lab.springdatalab.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import io.lab.springdatalab.model.Customer;
import io.lab.springdatalab.model.Order;
import io.lab.springdatalab.model.Product;
import io.lab.springdatalab.service.customer.CustomerService;
import io.lab.springdatalab.service.order.OrderService;
import io.lab.springdatalab.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    private ObjectMapper objectMapper = new ObjectMapper();


    //customer


    @PostMapping(value = "/customer")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @PutMapping(value = "/customer")
    public Customer updateCustomer(@RequestParam Long id, @RequestBody Customer customer) {
        customerService.getCustomer(id);
        return customerService.saveCustomer(customer);
    }

    @PatchMapping(value = "/customer",consumes = "application/json-patch+json")
    public ResponseEntity<Customer> patchCustomer(@RequestParam Long id, @RequestBody JsonPatch patch) throws JsonPatchException, JsonProcessingException {

        Customer customer = customerService.getCustomer(id);
        Customer customerPatched = applyPatchToCustomer(patch, customer);
        customerService.saveCustomer(customerPatched);

        return ResponseEntity.ok(customerPatched);
    }

    private Customer applyPatchToCustomer(JsonPatch patch, Customer targetCustomer) throws JsonPatchException, JsonProcessingException {

        JsonNode patched = patch.apply(objectMapper.convertValue(targetCustomer, JsonNode.class));
        return objectMapper.treeToValue(patched, Customer.class);
    }


    //order


    @PutMapping(value = "/order")
    public Order updateOrder(@RequestParam Long id, @RequestBody Order order){
        orderService.getOrder(id);
        return orderService.saveOrder(order);
    }

    @PatchMapping(value = "/order",consumes = "application/json-patch+json")
    public ResponseEntity<Order> patchOrder(@RequestParam Long id, @RequestBody JsonPatch patch) throws JsonPatchException, JsonProcessingException {

        Order order = orderService.getOrder(id);
        Order orderPatched = applyPatchToOrder(patch, order);
        orderService.saveOrder(orderPatched);

        return ResponseEntity.ok(orderPatched);
    }

    private Order applyPatchToOrder(JsonPatch patch, Order targetOrder) throws JsonPatchException, JsonProcessingException {

        JsonNode patched = patch.apply(objectMapper.convertValue(targetOrder, JsonNode.class));
        return objectMapper.treeToValue(patched, Order.class);
    }


    //product


    @PostMapping(value = "/product")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping(value = "/product")
    public Product updateProduct(@RequestParam Long id, @RequestBody Product product) {
        productService.getProduct(id);
        return productService.saveProduct(product);
    }

    @PatchMapping(value = "/product",consumes = "application/json-patch+json")
    public ResponseEntity<Product> patchProduct(@RequestParam Long id, @RequestBody JsonPatch patch) throws JsonPatchException, JsonProcessingException {

        Product product = productService.getProduct(id);
        Product productPatched = applyPatchToProduct(patch, product);
        productService.saveProduct(productPatched);


        return ResponseEntity.ok(productPatched);
    }

    private Product applyPatchToProduct(JsonPatch patch, Product targetProduct) throws JsonPatchException, JsonProcessingException {

        JsonNode patched = patch.apply(objectMapper.convertValue(targetProduct, JsonNode.class));
        return objectMapper.treeToValue(patched, Product.class);
    }


}

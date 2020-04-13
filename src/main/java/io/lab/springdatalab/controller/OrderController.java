package io.lab.springdatalab.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import io.lab.springdatalab.model.Customer;
import io.lab.springdatalab.model.Order;
import io.lab.springdatalab.service.order.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping(value = "/order/all")
    public Iterable<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping(value = "/order")
    public Order getOrderById(@RequestParam Long id){
        return orderService.getOrder(id);
    }

    @PostMapping(value = "/order")
    public Order createOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @PutMapping(value = "/admin/order")
    public Order updateOrder(@RequestParam Long id, @RequestBody Order order){
        orderService.getOrder(id);
        return orderService.saveOrder(order);
    }

    @PatchMapping(value = "/admin/order",consumes = "application/json-patch+json")
    public ResponseEntity<?> patchCustomer(@RequestParam Long id, @RequestBody JsonPatch patch) throws JsonPatchException, JsonProcessingException {

       Order order = orderService.getOrder(id);
        Order orderPatched = applyPatchToOrder(patch, order);
        orderService.saveOrder(orderPatched);

        return ResponseEntity.ok(orderPatched);
    }

    private Order applyPatchToOrder(JsonPatch patch, Order targetOrder) throws JsonPatchException, JsonProcessingException {

        JsonNode patched = patch.apply(objectMapper.convertValue(targetOrder, JsonNode.class));
        return objectMapper.treeToValue(patched, Order.class);
    }


}

package io.lab.springdatalab.controller;

import io.lab.springdatalab.model.Order;
import io.lab.springdatalab.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping(value = "/all")
    public Iterable<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping
    public Order getOrderById(@RequestParam Long id){
        return orderService.getOrder(id);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }




}

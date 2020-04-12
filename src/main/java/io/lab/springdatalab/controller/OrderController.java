package io.lab.springdatalab.controller;

import io.lab.springdatalab.model.Order;
import io.lab.springdatalab.service.order.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

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
    public Optional<Order> getOrderById(@RequestParam Long id){
        return orderService.getOrder(id);
    }
}

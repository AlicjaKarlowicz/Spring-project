package io.lab.springdatalab.service.order;

import io.lab.springdatalab.model.Customer;
import io.lab.springdatalab.model.Order;

import java.util.Optional;

public interface OrderService {

    Iterable<Order> getAllOrders();

    Optional<Order> getOrder(long id);

    Order saveOrder(Order order);
}

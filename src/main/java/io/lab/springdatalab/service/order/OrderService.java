package io.lab.springdatalab.service.order;

import io.lab.springdatalab.model.Order;

public interface OrderService {

    Iterable<Order> getAllOrders();

    Order getOrder(long id);

    Order saveOrder(Order order);
}

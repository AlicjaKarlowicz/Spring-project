package io.lab.springdatalab.service.order;

import io.lab.springdatalab.exception.ResourceNotFound;
import io.lab.springdatalab.model.Order;
import io.lab.springdatalab.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderServiceIml implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Override
    public Iterable<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public Order getOrder(long id) {
        return orderRepo.findById(id).orElseThrow(ResourceNotFound::new);

    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepo.save(order);
    }
}

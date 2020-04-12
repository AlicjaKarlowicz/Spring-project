package io.lab.springdatalab.service.order;

import io.lab.springdatalab.model.Customer;
import io.lab.springdatalab.model.Order;
import io.lab.springdatalab.repository.OrderRepo;
import io.lab.springdatalab.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

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
    public Optional<Order> getOrder(long id) {
        return orderRepo.findById(id);

    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepo.save(order);
    }
}

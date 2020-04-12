package io.lab.springdatalab;

import io.lab.springdatalab.repository.CustomerRepo;
import io.lab.springdatalab.repository.OrderRepo;
import io.lab.springdatalab.repository.ProductRepo;
import io.lab.springdatalab.model.Customer;
import io.lab.springdatalab.model.Order;
import io.lab.springdatalab.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Component
public class DbMockData {

    private ProductRepo productRepository;
    private OrderRepo orderRepository;
    private CustomerRepo customerRepository;

    @Autowired
    public DbMockData(ProductRepo productRepository, OrderRepo orderRepository, CustomerRepo customerRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fill() {
        Product p1 = new Product("TEAPIGS Peppermint Leaves 100g", 29.50f, true);
        Product p2 = new Product("NEW YORK CAFFE Extra P 1kg", 109f, true);
        Product p3 = new Product("BIALETTI Milano Roma 250g", 26.00f,true);
        Product p4 = new Product("TEAPIGS Chai Tea", 59.00f,false);
        Customer customer = new Customer("Janina Kowalczuk", "Wrocław");
        Set<Product> products = new HashSet<>() {
            {
                add(p1);
                add(p2);
                add(p3);
                add(p4);
            }};
        Order order = new Order(customer, products, LocalDateTime.now(), "in progress");

        productRepository.save(p1);
        productRepository.save(p2);
        customerRepository.save(customer);
        orderRepository.save(order);
    }
}

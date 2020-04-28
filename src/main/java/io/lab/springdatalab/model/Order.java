package io.lab.springdatalab.model;

import io.lab.springdatalab.model.Customer;
import io.lab.springdatalab.model.Product;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;
    
    @ManyToMany
    private Set<Product> products = new HashSet<>();
    private LocalDateTime placeDate;
    private String status;

    public Order() {
    }


    public Order(Customer customer, Set<Product> products) {
        this.customer = customer;
        this.products = products;
        this.placeDate = LocalDateTime.now();
        this.status = "in progress";
    }


    public Order(Customer customer, Set<Product> products,LocalDateTime placeDate, String status) {
        this.customer = customer;
        this.products = products;
        this.placeDate = placeDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public LocalDateTime getPlaceDate() {
        return placeDate;
    }

    public void setPlaceDate(LocalDateTime placeDate) {
        this.placeDate = placeDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

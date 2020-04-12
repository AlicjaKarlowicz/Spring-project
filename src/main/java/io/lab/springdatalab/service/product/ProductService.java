package io.lab.springdatalab.service.product;

import io.lab.springdatalab.model.Product;

import java.util.Optional;

public interface ProductService {

    Iterable<Product> getAllProducts();

    Optional<Product> getProduct(long id);

    Product addProduct(Product product);
}

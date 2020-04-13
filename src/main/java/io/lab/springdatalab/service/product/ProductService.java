package io.lab.springdatalab.service.product;

import io.lab.springdatalab.model.Product;

public interface ProductService {

    Iterable<Product> getAllProducts();

    Product getProduct(long id);

    Product saveProduct(Product product);
}

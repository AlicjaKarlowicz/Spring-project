package io.lab.springdatalab.service.product;

import io.lab.springdatalab.model.Product;
import io.lab.springdatalab.repository.ProductRepo;
import io.lab.springdatalab.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceIml implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> getProduct(long id) {
        return productRepo.findById(id);
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }
}

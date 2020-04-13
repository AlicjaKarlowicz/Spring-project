package io.lab.springdatalab.service.product;

import io.lab.springdatalab.exception.ResourceNotFound;
import io.lab.springdatalab.model.Product;
import io.lab.springdatalab.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
    public Product getProduct(long id) {
        return productRepo.findById(id).orElseThrow(ResourceNotFound::new);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

}

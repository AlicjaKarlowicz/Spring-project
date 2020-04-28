package io.lab.springdatalab.controller;

import io.lab.springdatalab.model.Product;
import io.lab.springdatalab.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping(value ="/all")
    public Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping
    public Product getProductById(@RequestParam Long id) {
        return productService.getProduct(id);
    }


}

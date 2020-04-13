package io.lab.springdatalab.controller;

import io.lab.springdatalab.model.Product;
import io.lab.springdatalab.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value ="/product/all")
    public Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(value = "/product")
    public Product getProductById(@RequestParam Long id) {
        return productService.getProduct(id);
    }

    @PostMapping(value = "/admin/product")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping(value = "/admin/product")
    public Product updateProduct(@RequestParam Long id, @RequestBody Product product) {
        Product p = productService.getProduct(id);
        return productService.saveProduct(product);
    }

}

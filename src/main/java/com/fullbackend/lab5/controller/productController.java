package com.fullbackend.lab5.controller;

import com.fullbackend.lab5.entity.Product;
import com.fullbackend.lab5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class productController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public Product findById (@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public void create (@RequestBody Product product) {
        productService.create(product);
    }

    @PutMapping("/products/{id}")
    public void update (@PathVariable Long id, @RequestBody Product product) {
        productService.update(id, product);
    }

    @DeleteMapping("/products/{id}")
    public void delete (@PathVariable Long id) {
        productService.delete(id);
    }

    @GetMapping("/products/greaterThan")
    public List<Product> getGreaterThan(@RequestParam double price) {
        return productService.getGreaterThan(price);
    }

    @GetMapping("/products/lowerThan")
    public List<Product> getLowerThan(@RequestParam double price) {
        return productService.getLowerThan(price);
    }
}

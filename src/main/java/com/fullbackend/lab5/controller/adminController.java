package com.fullbackend.lab5.controller;

import com.fullbackend.lab5.entity.Product;
import com.fullbackend.lab5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("admin")
public class adminController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById (@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create (@RequestBody Product product) {
        productService.create(product);
    }

    @PutMapping("{id}")
    public void update (@PathVariable Long id, @RequestBody Product product) {
        productService.update(id, product);
    }

    @DeleteMapping("{id}")
    public void delete (@PathVariable Long id) {
        productService.delete(id);
    }

    @GetMapping("greaterThan")
    public List<Product> getGreaterThan(@RequestParam double price) {
        return productService.getGreaterThan(price);
    }

    @GetMapping("lowerThan")
    public List<Product> getLowerThan(@RequestParam double price) {
        return productService.getLowerThan(price);
    }
}

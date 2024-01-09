package com.fullbackend.lab5.service;

import com.fullbackend.lab5.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product findById(Long id);
    void create(Product product);
    void update(Long id, Product product);
    void delete(Long id);
    List<Product> getGreaterThan(double price);
    List<Product> getLowerThan(double price);
}

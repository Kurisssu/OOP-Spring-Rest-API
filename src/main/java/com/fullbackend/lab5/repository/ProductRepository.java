package com.fullbackend.lab5.repository;

import com.fullbackend.lab5.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(Long id);
    void create(Product product);
    void update(Long id, Product product);
    void delete(Long id);
    boolean existById(Long id);
    boolean existByName(String name);
    List<Product> getGreaterThan(double price);
    List<Product> getLowerThan(double price);
}

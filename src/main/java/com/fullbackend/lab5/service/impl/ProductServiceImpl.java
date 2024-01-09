package com.fullbackend.lab5.service.impl;

import com.fullbackend.lab5.entity.Product;
import com.fullbackend.lab5.exeception.AlreadyExistException;
import com.fullbackend.lab5.exeception.NotFoundException;
import com.fullbackend.lab5.repository.ProductRepository;
import com.fullbackend.lab5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        if (!productRepository.existById(id)) {
            throw new NotFoundException("Not found product with id: " + id);
        }
        return productRepository.findById(id);
    }

    @Override
    public void create(Product product) {
        if (productRepository.existByName(product.getName())) {
            throw new AlreadyExistException("Already exist product with name: " + product.getName());
        }
        productRepository.create(product);
    }

    @Override
    public void update(Long id, Product product) {
        productRepository.update(id, product);
    }

    @Override
    public void delete(Long id) {
        productRepository.delete(id);
    }

    @Override
    public List<Product> getGreaterThan(double price) {
        return productRepository.getGreaterThan(price);
    }

    @Override
    public List<Product> getLowerThan(double price) {
        return productRepository.getLowerThan(price);
    }
}

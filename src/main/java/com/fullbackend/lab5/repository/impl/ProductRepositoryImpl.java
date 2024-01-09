package com.fullbackend.lab5.repository.impl;

import com.fullbackend.lab5.entity.Product;
import com.fullbackend.lab5.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query("select * from Product", (rs, rowNum) ->
                new Product(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("manufacturer"),
                        rs.getDouble("price")
                ));


    }

    @Override
    public Product findById(Long id) {
        String sql = "select * from Product where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new Product(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("manufacturer"),
                        rs.getDouble("price")
                        ));
    }


    public void create(Product product) {
        jdbcTemplate.update("insert into Product(name, manufacturer, price) values (?, ?, ?)",
                product.getName(),
                product.getManufacturer(),
                product.getPrice());
    }

    @Override
    public void update(Long id, Product product) {
        jdbcTemplate.update("update Product set name = ?, manufacturer = ?, price = ? where id = ?",
                product.getName(),
                product.getManufacturer(),
                product.getPrice(),
                id);
    }

    public void delete(Long id) {
        jdbcTemplate.update("delete from Product where id = ?", id);
    }

    public boolean existById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }

        try {
            Integer count = jdbcTemplate.queryForObject("select count(*) from Product where id = ?", Integer.class, id);
            return count != null && count > 0;
        } catch (IncorrectResultSizeDataAccessException ex) {
            return false;
        }
    }

    public boolean existByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }

        try {
            Integer count = jdbcTemplate.queryForObject("select count(*) from Product where name = ?", Integer.class, name);
            return count != null && count > 0;
        } catch (IncorrectResultSizeDataAccessException ex) {
            return false;
        }
    }


    @Override
    public List<Product> getGreaterThan(double price) {
        return jdbcTemplate.query("select * from Product where price > ?", (rs, rowNum) ->
            new Product(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("manufacturer"),
                    rs.getDouble("price")
            ), price);
    }

    @Override
    public List<Product> getLowerThan(double price) {
        return jdbcTemplate.query("select * from Product where price < ?", (rs, rowNum) ->
                new Product(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("manufacturer"),
                        rs.getDouble("price")
                ), price);
    }
}
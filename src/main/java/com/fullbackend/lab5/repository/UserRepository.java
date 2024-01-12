package com.fullbackend.lab5.repository;

import com.fullbackend.lab5.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User findById(Long id);
    void create(User user);
    void update(Long id, User user);
    void delete(Long id);
    boolean existById(Long id);
    boolean existByName(String name);
}


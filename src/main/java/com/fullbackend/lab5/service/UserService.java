package com.fullbackend.lab5.service;

import com.fullbackend.lab5.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findById(Long id);
    void create(User user);
    void update(Long id, User user);
    void delete(Long id);
}

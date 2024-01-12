package com.fullbackend.lab5.repository;

import com.fullbackend.lab5.entity.Admin;

import java.util.List;

public interface AdminRepository {
    List<Admin> findAll();
    Admin findById(Long id);
    void create(Admin admin);
    void update(Long id, Admin admin);
    void delete(Long id);
    boolean existById(Long id);
    boolean existByName(String name);
}


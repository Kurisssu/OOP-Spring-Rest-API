package com.fullbackend.lab5.service;

import com.fullbackend.lab5.entity.Admin;

import java.util.List;

public interface AdminService {

    List<Admin> findAll();
    Admin findById(Long id);
    void create(Admin admin);
    void update(Long id, Admin admin);
    void delete(Long id);
}

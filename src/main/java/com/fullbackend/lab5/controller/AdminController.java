package com.fullbackend.lab5.controller;

import com.fullbackend.lab5.entity.Admin;
import com.fullbackend.lab5.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admins")
    public List<Admin> findAll() {
        return adminService.findAll();
    }

    @GetMapping("/admins/{id}")
    public Admin findById (@PathVariable Long id) {
        return adminService.findById(id);
    }

    @PostMapping("/admins")
    @ResponseStatus(HttpStatus.CREATED)
    public void create (@RequestBody Admin admin) {
        adminService.create(admin);
    }

    @PutMapping("/admins/{id}")
    public void update (@PathVariable Long id, @RequestBody Admin admin) {
        adminService.update(id, admin);
    }

    @DeleteMapping("/admins/{id}")
    public void delete (@PathVariable Long id) {
        adminService.delete(id);
    }
}
package com.fullbackend.lab5.controller;

import com.fullbackend.lab5.entity.User;
import com.fullbackend.lab5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User findById (@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void create (@RequestBody User user) {
        userService.create(user);
    }

    @PutMapping("/users/{id}")
    public void update (@PathVariable Long id, @RequestBody User user) {
        userService.update(id, user);
    }

    @DeleteMapping("/users/{id}")
    public void delete (@PathVariable Long id) {
        userService.delete(id);
    }
}

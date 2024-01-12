package com.fullbackend.lab5.service.impl;

import com.fullbackend.lab5.entity.User;
import com.fullbackend.lab5.exeception.AlreadyExistException;
import com.fullbackend.lab5.exeception.NotFoundException;
import com.fullbackend.lab5.repository.UserRepository;
import com.fullbackend.lab5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        if (!userRepository.existById(id)) {
            throw new NotFoundException("Not found user with id: " + id);
        }
        return userRepository.findById(id);
    }

    @Override
    public void create(User user) {
        if (userRepository.existByName(user.getName())) {
            throw new AlreadyExistException("Already exist user with name: " + user.getName());
        }
        userRepository.create(user);
    }

    @Override
    public void update(Long id, User user) {
        userRepository.update(id, user);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}


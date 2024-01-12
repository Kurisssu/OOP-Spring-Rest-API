package com.fullbackend.lab5.service.impl;

import com.fullbackend.lab5.entity.Admin;
import com.fullbackend.lab5.exeception.AlreadyExistException;
import com.fullbackend.lab5.exeception.NotFoundException;
import com.fullbackend.lab5.repository.AdminRepository;
import com.fullbackend.lab5.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin findById(Long id) {
        if (!adminRepository.existById(id)) {
            throw new NotFoundException("Not found admin with id: " + id);
        }
        return adminRepository.findById(id);
    }

    @Override
    public void create(Admin admin) {
        if (adminRepository.existByName(admin.getName())) {
            throw new AlreadyExistException("Already exist admin with name: " + admin.getName());
        }
        adminRepository.create(admin);
    }

    @Override
    public void update(Long id, Admin admin) {
        adminRepository.update(id, admin);
    }

    @Override
    public void delete(Long id) {
        adminRepository.delete(id);
    }
}
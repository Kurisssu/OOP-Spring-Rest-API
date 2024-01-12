package com.fullbackend.lab5.repository.impl;

import com.fullbackend.lab5.entity.Admin;
import com.fullbackend.lab5.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminRepositoryImpl implements AdminRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Admin> findAll() {
        return jdbcTemplate.query("select * from AdminTable", (rs, rowNum) ->
                new Admin(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email")
                ));


    }

    @Override
    public Admin findById(Long id) {
        String sql = "select * from AdminTable where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new Admin(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email")
                ));
    }


    public void create(Admin admin) {
        jdbcTemplate.update("insert into AdminTable(name, email) values (?, ?)",
                admin.getName(),
                admin.getEmail());

    }

    @Override
    public void update(Long id, Admin admin) {
        jdbcTemplate.update("update AdminTable set name = ?, email = ? where id = ?",
                admin.getName(),
                admin.getEmail(),
                id);
    }

    public void delete(Long id) {
        jdbcTemplate.update("delete from AdminTable where id = ?", id);
    }

    public boolean existById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }

        try {
            Integer count = jdbcTemplate.queryForObject("select count(*) from AdminTable where id = ?", Integer.class, id);
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
            Integer count = jdbcTemplate.queryForObject("select count(*) from AdminTable where name = ?", Integer.class, name);
            return count != null && count > 0;
        } catch (IncorrectResultSizeDataAccessException ex) {
            return false;
        }
    }
}

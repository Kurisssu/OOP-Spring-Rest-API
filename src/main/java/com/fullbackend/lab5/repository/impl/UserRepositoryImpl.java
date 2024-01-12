package com.fullbackend.lab5.repository.impl;

import com.fullbackend.lab5.entity.User;
import com.fullbackend.lab5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from UserTable", (rs, rowNum) ->
                new User(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email")
                ));


    }

    @Override
    public User findById(Long id) {
        String sql = "select * from UserTable where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new User(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email")
                ));
    }


    public void create(User user) {
        jdbcTemplate.update("insert into UserTable(name, email) values (?, ?)",
                user.getName(),
                user.getEmail());

    }

    @Override
    public void update(Long id, User user) {
        jdbcTemplate.update("update UserTable set name = ?, email = ? where id = ?",
                user.getName(),
                user.getEmail(),
                id);
    }

    public void delete(Long id) {
        jdbcTemplate.update("delete from UserTable where id = ?", id);
    }

    public boolean existById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }

        try {
            Integer count = jdbcTemplate.queryForObject("select count(*) from UserTable where id = ?", Integer.class, id);
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
            Integer count = jdbcTemplate.queryForObject("select count(*) from UserTable where name = ?", Integer.class, name);
            return count != null && count > 0;
        } catch (IncorrectResultSizeDataAccessException ex) {
            return false;
        }
    }
}

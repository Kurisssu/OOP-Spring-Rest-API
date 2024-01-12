package com.fullbackend.lab5.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table(name = "AdminTable")
public class Admin {
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String email;

    private List<Admin> admin;

    public Admin(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id =" + id +
                ", name ='" + name + '\'' +
                ", email ='" + email + '\'' +
                '}';
    }
}
package com.fullbackend.lab5.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table(name = "Product")
public class Product {
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String manufacturer; // producer, maker
    @Getter @Setter
    private Double price;

    private List<Product> product;

    public Product(Long id, String name, String manufacturer, Double price) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id =" + id +
                ", name ='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price ='" + price + '\'' +
                '}';
    }
}

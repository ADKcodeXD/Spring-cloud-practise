package com.adk.entity;

import java.util.Date;

public class Product {
    private Integer id;
    private String name;
    private Date date;

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Product(Integer id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }
}

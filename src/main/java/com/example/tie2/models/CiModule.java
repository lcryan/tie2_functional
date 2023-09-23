package com.example.tie2.models;

import jakarta.persistence.*;

@Entity
@Table
public class CiModule {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;

    public CiModule(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public CiModule() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

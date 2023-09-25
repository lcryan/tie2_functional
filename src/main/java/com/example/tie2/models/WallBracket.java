package com.example.tie2.models;

import jakarta.persistence.*;

@Entity
@Table
public class WallBracket {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "size")
    private String size;
    @Column(name = "adjustable")
    private boolean adjustable;
    @Column(name = "price")
    private double price;

    public WallBracket(Long id, String name, String size, boolean adjustable, double price) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.adjustable = adjustable;
        this.price = price;
    }

    public WallBracket() {

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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isAdjustable() {
        return adjustable;
    }

    public void setAdjustable(boolean adjustable) {
        this.adjustable = adjustable;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

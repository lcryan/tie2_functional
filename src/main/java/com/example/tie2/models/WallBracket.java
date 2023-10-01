package com.example.tie2.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "wall_brackets")
public class WallBracket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "size")
    private String size;
    @Column(name = "adjustable")
    private boolean adjustable;
    @Column(name = "price")
    private double price;
    //Establishing Many to Many
    @ManyToMany(mappedBy = "wallBracketList")
    private List<Television> televisionList;

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

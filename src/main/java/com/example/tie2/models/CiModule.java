package com.example.tie2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ci_modules")
public class CiModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private double price;

    // Establishing One-TO-Many relation with Television  - this is the target side : there is nothing in the db here //
    @OneToMany(mappedBy = "ciModule")
    @JsonIgnore
    private List<Television> televisionList;

    //NOTE: there is no getter or setter here!!! //
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

package com.example.tie2.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public class WallBracketInputDto {
    private Long id;
    @NotEmpty(message = "Name must be assigned.")
    private String name;
    private String size;
    private boolean adjustable;
    @Positive(message = "Price must be higher than zero.")
    private double price;

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

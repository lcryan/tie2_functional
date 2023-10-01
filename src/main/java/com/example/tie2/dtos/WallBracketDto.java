package com.example.tie2.dtos;

public class WallBracketDto {
    private Long id;
    private String name;
    private String size;
    private boolean adjustable;
    private Double price;

    public WallBracketDto() {
    }

    public WallBracketDto(Long id, String name, String size, boolean adjustable, Double price) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.adjustable = adjustable;
        this.price = price;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

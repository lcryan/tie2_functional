package com.example.tie2.dtos;


import com.example.tie2.models.Television;

public class RemoteControlDto {
    private Long id;
    private String name;
    private String brand;
    private String compatibleWith;
    private String batteryType;
    private Integer originalStock;
    private Double price;

    public RemoteControlDto() {
    }

    public RemoteControlDto(Long id, String name, String brand, String compatibleWith, String batteryType, Integer originalStock, Double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.compatibleWith = compatibleWith;
        this.batteryType = batteryType;
        this.originalStock = originalStock;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}

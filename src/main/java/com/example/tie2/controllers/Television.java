package com.example.tie2.controllers;

public class Television {
    private String televisionName;

    public int getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(int totalStock) {
        this.totalStock = totalStock;
    }

    private int totalStock;
    private boolean HD;

    public Television(int totalStock) {
        this.totalStock = totalStock;
    }

    public boolean isHD() {
        return HD;
    }

    public void setHD(boolean HD) {
        this.HD = HD;
    }

    public void setTelevisionName(String televisionName) {
        this.televisionName = televisionName;
    }

    public String getTelevisionName() {
        return televisionName;
    }

    public boolean getHD() {
        return HD;
    }

    public Television(String televisionName, boolean HD, int totalStock) {
        this.televisionName = televisionName;
        this.HD = HD;
        this.totalStock = totalStock;
    }
}



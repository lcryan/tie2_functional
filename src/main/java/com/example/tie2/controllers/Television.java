package com.example.tie2.controllers;

public class Television {
    /*  private final String television;*/
    private final String televisionName;
    private final long id;


    public String getTelevisionName() {
        return televisionName;
    }

    public long getId() {
        return id;
    }

    public Television(String televisionName, long id) {


        this.televisionName = televisionName;
        this.id = id;

    }
}

  /*  public String findById(Long televisionId) {
        return Television;
    }
}*/ //TODO: make a working getById method //

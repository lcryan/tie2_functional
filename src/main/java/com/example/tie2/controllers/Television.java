package com.example.tie2.controllers;

import org.springframework.boot.autoconfigure.domain.EntityScan;

public class Television {
    String televisionName;
    int id;

    public void setTelevisionName(String televisionName) {
        this.televisionName = televisionName;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTelevisionName() {
        return televisionName;
    }

    public long getId() {
        return id;
    }

    public Television(String televisionName, int id) {
        this.televisionName = televisionName;
        this.id = id;
    }
}

  /*  public String findById(Long televisionId) {
        return Television;
    }



/*

// with existing database //
@Entity
@Table(name = “books”)
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String isbn;
    @Column(name = "title")
    private String mainTitle;
    private String genre;
    Public Long getId(){
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }
    Public void setId(Long id){
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
} */

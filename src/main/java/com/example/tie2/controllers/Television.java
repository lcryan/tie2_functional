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


    public Television(String televisionName, boolean HD, int totalStock) {
        this.televisionName = televisionName;
        this.HD = HD;
        this.totalStock = totalStock;

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

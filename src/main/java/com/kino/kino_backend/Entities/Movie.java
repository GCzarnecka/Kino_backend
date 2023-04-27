package com.kino.kino_backend.Entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movies")
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    @ManyToOne
    private Category category;

    @Temporal(TemporalType.DATE)
    private int productionDate;

    private int ageRestriction;

    private int duration;

    @Column(length = 5000)
    private String description;


    @ManyToOne
    private Author author;

    private String poster;
    public Movie() {
    }
    public Movie(String title, Category category, int productionDate,
                 int ageRestriction, int duration, Author author, String poster,
                 String description
    ) {
        this.title = title;
        this.category = category;
        this.productionDate = productionDate;
        this.ageRestriction = ageRestriction;
        this.duration = duration;
        this.author = author;
        this.poster = poster;
        this.description = description;
    }

//    public Movie(String s, String s1, String url, int i, int i1, int i2) {
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(int productionDate) {
        this.productionDate = productionDate;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}


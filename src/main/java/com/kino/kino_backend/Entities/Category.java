package com.kino.kino_backend.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "categories")
@Data
public class Category {

    String name;
    String description;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    //powiązanie z filmem
    @OneToMany
//    @JoinColumn(name = "movie_id")
    private List<Movie> movie;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Movie> getMovie() {
        return movie;
    }

    public void setMovie(List<Movie> movie) {
        this.movie = movie;
    }
}

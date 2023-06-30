/**

 Entity class representing a category.
 */
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

    @OneToMany
    private List<Movie> movie;


    /**
     * Retrieves the name of the category.
     *
     * @return the name of the category
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the name of the category.
     *
     * @param name the name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the description of the category.
     *
     * @return the description of the category
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the category.
     *
     * @param description the description to be set
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Retrieves the ID of the category.
     *
     * @return the ID of the category
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the category.
     *
     * @param id the ID to be set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the list of movies in the category.
     *
     * @return the list of movies in the category
     */
    public List<Movie> getMovie() {
        return movie;
    }

    /**
     * Sets the list of movies in the category.
     *
     * @param movie the list of movies to be set
     */
    public void setMovie(List<Movie> movie) {
        this.movie = movie;
    }
}

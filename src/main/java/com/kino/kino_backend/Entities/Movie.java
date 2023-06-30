/**

 Entity class representing a movie.
 */
package com.kino.kino_backend.Entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "movies")
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * The title of the movie.
     */
    private String title;

    /**
     * The category of the movie.
     */
    @ManyToOne
    private Category category;


    /**
     * The production date of the movie.
     */
    @Temporal(TemporalType.DATE)
    private int productionDate;


    /**
     * The age restriction of the movie.
     */
    private int ageRestriction;


    /**
     * The duration of the movie in minutes.
     */
    private int duration;


    /**
     * The description of the movie.
     */
    @Column(length = 5000)
    private String description;

    /**
     * The author of the movie.
     */
    @ManyToOne
    private Author author;

    /**
     * The URL of the movie poster.
     */
    @Column(length = 5000)
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
    /**
     * Retrieves the id of the movie.
     *
     * @return the id of the movie
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id of the movie.
     *
     * @param id the id to be set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the title of the movie.
     * @return the title of the movie
     */
    public String getTitle() {
        return title;
    }
    /**
     * Sets the title of the movie.
     *
     * @param title the title to be set
     */
    public void setTitle(String title) {
        this.title = title;
    }

}


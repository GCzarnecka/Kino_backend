/**

 Represents a screening of a movie in a cinema room.
 */
package com.kino.kino_backend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.time.LocalDateTime;

@Entity
@Table(name = "screenings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private CinemaRoom cinemaRoom;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Seat> seats;

    private LocalDateTime startTime;

    private double price;

    /**
     * Constructs a Screening object with the provided movie, cinema room, start time, and seats.
     *
     * @param movie      the movie being screened
     * @param cinemaRoom the cinema room where the screening takes place
     * @param date  the start time of the screening
     * @param seats      the list of seats available for the screening
     */
    public Screening(Movie movie, CinemaRoom cinemaRoom, LocalDateTime date, List<Seat> seats) {
        this.movie = movie;
        this.cinemaRoom = cinemaRoom;
        this.startTime = date;
        this.seats = seats;
    }

    /**
     * Returns the ID of the screening.
     *
     * @return the ID of the screening
     */
    public Integer getId() {
        return id;
    }


    /**
     * Sets the ID of the screening.
     *
     * @param id the ID of the screening
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returns the movie being screened.
     *
     * @return the movie being screened
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Sets the movie being screened.
     *
     * @param movie the movie being screened
     */
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    /**
     * Returns the cinema room where the screening takes place.
     */
    public void setCinemaRoom(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    /**
     * Sets the cinema room where the screening takes place.
     *
     * @param startTime the cinema room where the screening takes place
     */
    public void setStartDateTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }



}

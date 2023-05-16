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

    @ManyToOne //(cascade = CascadeType.ALL)
    private Movie movie;

    @ManyToOne
    private CinemaRoom cinemaRoom;

    @OneToMany
    private List<Seat> seats;

    private LocalDateTime startTime;

    public Screening(Movie movie, CinemaRoom cinemaRoom, LocalDateTime date, List<Seat> seats) {
        this.movie = movie;
        this.cinemaRoom = cinemaRoom;
        this.startTime = date;
        this.seats = seats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }

    public void setCinemaRoom(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartDateTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }



}

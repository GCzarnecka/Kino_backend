package com.kino.kino_backend.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "screenings")
@Data
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
//    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    private CinemaRoom cinemaRoom;

//    @Column(name = "screening_time")
//    private LocalDateTime screeningTime;

//    @OneToMany(mappedBy = "screening")
//    private List<Reservation> reservations;

    private LocalDateTime startTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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


//    public boolean isSeatAvailableForScreening(Seat seat, Screening screening) {
//        for (Reservation reservation : seat.getReservations()) {
//            if (reservation.getScreening().equals(screening)) {
//                return false;
//            }
//        }
//        return true;
//    }



}

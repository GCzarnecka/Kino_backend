package com.kino.kino_backend.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "reservations")
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

//    @ManyToOne
//    @JoinColumn(name = "screening_id")
//    private Screening screening;

//    @OneToMany//(mappedBy = "messageComplaints")
//    private List<MessageComplaint> messageComplaint;

    @ManyToOne
//    @JoinColumn(name = "user_id")
    private User user;


//    @JoinColumn(name = "movie_id")
//    @ManyToMany//(mappedBy = "movies")
//    private List<Movie> movies;

    @OneToOne
    private Screening screening;

    @OneToMany
//    @JoinColumn(name = "seat_id")
    private List<Seat> seats;

//    @Column(name = "reservation_time")
    private LocalDateTime reservationTime;

//    @Column(name = "archived")
    private boolean archived;

//    @Column(name = "paid")
    private boolean paid;

//    @Column(name = "price")
    private double price;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}


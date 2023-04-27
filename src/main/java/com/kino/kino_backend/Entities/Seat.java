package com.kino.kino_backend.Entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "seats")
@Data
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int sectorNumber;
//
    private int seatNumber;

    private boolean isTaken;

    @ManyToOne
    private CinemaRoom cinemaRoom;

    public Seat(int i, int i1, CinemaRoom cinemaRoom) {
        this.sectorNumber = i;
        this.seatNumber = i1;
//        this.cinemaRoom = cinemaRoom;
    }

    public Seat() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSectorNumber() {
        return sectorNumber;
    }

    public void setSectorNumber(int rowNumber) {
        this.sectorNumber = rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }



}

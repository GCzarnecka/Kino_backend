/**

 Represents a seat in a cinema room.
 */
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

    private int seatNumber;

    private boolean isTaken;

    /**
     * Default constructor for Seat class.
     */
    public Seat() {
    }

    /**
     * Constructs a Seat object with the specified sector number and seat number.
     *
     * @param sector the sector number of the seat
     * @param seatNr   the seat number
     * @param isTaken      the seat number
     */
    public Seat(int sector, int seatNr, boolean isTaken) {
        this.sectorNumber = sector;
        this.seatNumber = seatNr;
        this.isTaken = isTaken;
    }

    /**
     * Returns the ID of the seat.
     *
     * @return the ID of the seat
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the seat.
     *
     * @param id the ID of the seat
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Returns the taken status of the seat.
     *
     * @return the taken status of the seat
     */
    public boolean isTaken() {
        return isTaken;
    }
    /**
     * Sets the taken status of the seat.
     *
     * @param taken the taken status of the seat
     */
    public void setTaken(boolean taken) {
        isTaken = taken;
    }



}

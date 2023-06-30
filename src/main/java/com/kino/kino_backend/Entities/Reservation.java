/**
 * Entity class representing a reservation.
 */
package com.kino.kino_backend.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "reservations")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @ManyToOne(cascade = CascadeType.PERSIST)
    private Screening screening;

    @ElementCollection
    private List<Integer> seatsIds;

    private LocalDateTime reservationTime;

    private boolean archived;

    private boolean paid;

    private double price;


    /**
     * Retrieves the ID of the reservation.
     *
     * @return The ID of the reservation.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the reservation.
     *
     * @param id The ID of the reservation.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the list of seat IDs associated with the reservation.
     *
     * @return The list of seat IDs.
     */
    public List<Integer> getSeatsIds() {
        return seatsIds;
    }

    /**
     * Sets the list of seat IDs associated with the reservation.
     *
     * @param seats The list of seat IDs.
     */
    public void setSeatsIds(List<Integer> seats) {
        this.seatsIds = seats;
    }

    /**
     * Checks if the reservation has been paid.
     *
     * @return True if the reservation has been paid, false otherwise.
     */
    public boolean isPaid() {
        return paid;
    }

    /**
     * Sets the payment status of the reservation.
     *
     * @param paid The payment status of the reservation.
     */
    public void setPaid(boolean paid) {
        this.paid = paid;
    }

}


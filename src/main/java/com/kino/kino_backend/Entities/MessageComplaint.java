/**

 Entity class representing a message complaint.
 */
package com.kino.kino_backend.Entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "message_complaints")
@Data
public class MessageComplaint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    /**
     * The reservation associated with the complaint.
     */
    @ManyToOne
    private Reservation reservation;


    /**
     * The message of the complaint.
     */
    private String message;


    /**
     * The date of the complaint.
     */
    private Date complaintDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


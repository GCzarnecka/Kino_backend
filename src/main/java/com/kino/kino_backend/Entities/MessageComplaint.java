package com.kino.kino_backend.Entities;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.logging.log4j.message.Message;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "message_complaints")
@Data
public class MessageComplaint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Reservation reservation;

    private String message;

    private Date complaintDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(Date complaintDate) {
        this.complaintDate = complaintDate;
    }
}

//public class MessageComplaint {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    private String message;
//
//    @Column(name = "complaint_reason")
//    private String complaintReason;
//
//    @Column(name = "complaint_date")
//    private LocalDateTime complaintDate;
//}

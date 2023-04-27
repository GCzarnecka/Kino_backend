package com.kino.kino_backend.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "cinema_rooms")
@Data
public class CinemaRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    String name;
    @OneToMany//(mappedBy = "seats")
    private List<Seat> seats;


    @OneToMany//(mappedBy = "screenings")
    private List<Screening> screenings;

    @OneToOne//(mappedBy = "movies")
    private Movie movie;
//

       private int rowsNumber;
       private int columnsNumber;
}

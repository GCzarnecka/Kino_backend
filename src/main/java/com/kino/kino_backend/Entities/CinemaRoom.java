package com.kino.kino_backend.Entities;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Table(name = "cinema_rooms")
@Data
public class CinemaRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    String name;
    private int rowsNumber;
    private int columnsNumber;
}

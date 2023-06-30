/**

 Entity class representing a cinema room.
 */
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

    /**
     * The name of the cinema room.
     */
    String name;


    /**
     * The number of rows in the cinema room.
     */
    private int rowsNumber;

    /**
     * The number of columns in the cinema room.
     */
    private int columnsNumber;
}

/**

 Entity class representing an author.
 */
package com.kino.kino_backend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;


    private int age;


    /**
     * Constructs a new Author object with the specified name and age.
     *
     * @param name the name of the author
     * @param age  the age of the author
     */
    public Author(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Retrieves the ID of the author.
     *
     * @return the ID of the author
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the author.
     *
     * @param id the ID to be set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the author.
     *
     * @return the name of the author
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the author.
     *
     * @param name the name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the age of the author.
     *
     * @return the age of the author
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the author.
     *
     * @param age the age to be set
     */
    public void setAge(int age)  {
        this.age = age;
    }

}

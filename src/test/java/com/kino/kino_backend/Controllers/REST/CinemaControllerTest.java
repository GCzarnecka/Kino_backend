package com.kino.kino_backend.Controllers.REST;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CinemaControllerTest {

    @Autowired
    CinemaController cinemaController;

    @Test
    void getMovie() {
        var movie = cinemaController.getMovie(1l);
        assertNotEquals (movie, null);
    }

    @Test
    void getAllMovies() {

    }

    @Test
    void getAllCategories() {


    }

    @Test
    void getAllRooms() {
    }

    @Test
    void getAllAuthors() {
    }

    @Test
    void createMovie() {
    }

    @Test
    void getScreeningByMovieId() {
    }

    @Test
    void createScreening() {
    }
}
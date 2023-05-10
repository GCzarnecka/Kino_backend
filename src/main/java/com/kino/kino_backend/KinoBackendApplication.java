package com.kino.kino_backend;

import com.kino.kino_backend.ICinemaInit.CinemaInit;
import com.kino.kino_backend.ICinemaInit.ICinemaInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KinoBackendApplication implements CommandLineRunner {
    @Autowired
    CinemaInit cinemaInit;

    public static void main(String[] args) {
        SpringApplication.run(KinoBackendApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
//        cinemaInit.initAuthors();
//        cinemaInit.initCategories();
//        cinemaInit.initCinemaRooms();
////        cinemaInit.initMessageComplaints();
//        cinemaInit.initMovies();
//        cinemaInit.initReservations();
//        cinemaInit.initScreenings();
//        cinemaInit.initSeats();
//        cinemaInit.initUsers();
    }

}

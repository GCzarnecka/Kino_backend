package com.kino.kino_backend.Repositories;

import com.kino.kino_backend.Entities.Movie;
import com.kino.kino_backend.Entities.Reservation;
import com.kino.kino_backend.Entities.Seat;
import com.kino.kino_backend.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

//    List<Reservation> findByUser(User user);
//    List<Reservation> findByMovie(Movie movie);
//    List<Reservation> findBySeats(Seat seat);
//    List<Reservation> findByReservationTimeBetween(LocalDateTime start, LocalDateTime end);

}

package com.kino.kino_backend.Repositories;

import com.kino.kino_backend.Entities.CinemaRoom;
import com.kino.kino_backend.Entities.Screening;
import com.kino.kino_backend.Entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
//    List<Seat> findByCinemaRoom(CinemaRoom cinemaRoom);
//    List<Seat> findByScreeningAndReservationIsNull(Screening screening);
}

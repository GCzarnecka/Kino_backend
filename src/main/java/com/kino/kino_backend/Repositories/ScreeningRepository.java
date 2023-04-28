package com.kino.kino_backend.Repositories;

import com.kino.kino_backend.Entities.CinemaRoom;
import com.kino.kino_backend.Entities.Movie;
import com.kino.kino_backend.Entities.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    List<Screening> findByMovie(Movie movie);

//    List<Screening> findByMovieAndStartTimeBetween(Movie movie, LocalDateTime startTime, LocalDateTime endTime);
//    List<Screening> findByStartTimeBetween(LocalDateTime startTime, LocalDateTime endTime);
//    List<Screening> findByCinemaRoomAndStartTimeBetween(CinemaRoom cinemaRoom, LocalDateTime startTime, LocalDateTime endTime);
//
//    void reserveSeat(Long id, int id1);
//
//    Screening findByMovieAndCinemaRoom(Movie movie, CinemaRoom cinemaRoom);

//    boolean isSeatAvailableForScreening(int id, int id1);
}

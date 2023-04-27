package com.kino.kino_backend.Repositories;

import com.kino.kino_backend.Entities.CinemaRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRoomRepository extends JpaRepository<CinemaRoom, Long> {

//    List<CinemaRoom> findByCapacityGreaterThanEqual(int capacity);
//
//    List<CinemaRoom> findByName(String name);

}

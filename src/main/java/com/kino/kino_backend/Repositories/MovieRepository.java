package com.kino.kino_backend.Repositories;

import com.kino.kino_backend.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findByTitle(String s);
//    List<Movie> findAll();
//    Movie findById(int id);//moze jednak long?
//    List<Movie> findByTitleContaining(String keyword);
//    List<Movie> findByAgeRestriction(int ageRestriction);
//    List<Movie> findByProductionDateBetween(LocalDate start, LocalDate end);
//    List<Movie> findByCategoryName(String categoryName);
}

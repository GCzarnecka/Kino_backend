package com.kino.kino_backend.Repositories;

import com.kino.kino_backend.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
//    Author findByNameAndSurname(String name, String surname);
//    List<Author> findByAgeGreaterThan(int age);
}

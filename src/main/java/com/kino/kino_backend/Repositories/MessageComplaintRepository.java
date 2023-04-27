package com.kino.kino_backend.Repositories;

import com.kino.kino_backend.Entities.MessageComplaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@Repository
//@RepositoryRestResource
//@CrossOrigin("*")
public interface MessageComplaintRepository extends JpaRepository<MessageComplaint, Long> {
    // Dodajemy własne metody zapytań, np. do wyszukania skargi po tytule filmu
//    Optional<MessageComplaint> findByMovieTitle(String title);
}

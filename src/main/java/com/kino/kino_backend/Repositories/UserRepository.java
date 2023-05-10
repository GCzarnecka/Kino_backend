package com.kino.kino_backend.Repositories;

import com.kino.kino_backend.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    User findByUsername(String username);
    Optional<User> findByEmail(String email);
//    Optional<User> findByUsername(String username);
}

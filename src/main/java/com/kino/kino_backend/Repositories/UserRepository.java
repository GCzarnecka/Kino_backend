package com.kino.kino_backend.Repositories;

import com.kino.kino_backend.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
//    User findByUsername(String username);
//    User findByEmail(String email);
}

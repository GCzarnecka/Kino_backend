package com.kino.kino_backend.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.kino.kino_backend.Entities.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
//    List<Object> findByName(String action);
    Category findByName(String name);
}

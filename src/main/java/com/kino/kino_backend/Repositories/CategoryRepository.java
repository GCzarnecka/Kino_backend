package com.kino.kino_backend.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.kino.kino_backend.Entities.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
//    Category findByName(String name);
}

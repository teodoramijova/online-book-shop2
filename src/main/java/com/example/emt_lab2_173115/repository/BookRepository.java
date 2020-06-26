package com.example.emt_lab2_173115.repository;

import com.example.emt_lab2_173115.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    boolean existsByCategoryId(Long id);
}

package com.example.emt_lab2_173115.repository;

import com.example.emt_lab2_173115.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Transactional
    Integer removeById(Long id);
}

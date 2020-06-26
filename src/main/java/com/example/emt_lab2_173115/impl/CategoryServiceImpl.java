package com.example.emt_lab2_173115.impl;

import com.example.emt_lab2_173115.entity.Category;
import com.example.emt_lab2_173115.repository.CategoryRepository;
import com.example.emt_lab2_173115.service.CategoryService;
import com.example.emt_lab2_173115.exception.CategoryNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return this.categoryRepository.findById(id) .orElseThrow(() -> new
                CategoryNotFoundException(id));
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category update(Long id, Category category) {
        Category updatedCategory = this.findById(id);
        updatedCategory.setNameCat(category.getNameCat());
        updatedCategory.setDescCat(category.getDescCat());
        return this.categoryRepository.save(updatedCategory);
    }

    @Override
    public void deleteById(Long id) {
        Category category = this.findById(id);
        this.categoryRepository.removeById(id);
    }

}

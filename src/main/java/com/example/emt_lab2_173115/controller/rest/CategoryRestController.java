package com.example.emt_lab2_173115.controller.rest;

import com.example.emt_lab2_173115.entity.Category;
import com.example.emt_lab2_173115.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {

    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public List<Category> findAll() {
        return this.categoryService.findAll();
    }


    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id) {
        return this.categoryService.findById(id);
    }

    @PostMapping
    public Category save(@Valid Category category) {
        return this.categoryService.save(category);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @Valid Category category) {
        return this.categoryService.update(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        this.categoryService.deleteById(id);
    }

}

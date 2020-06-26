package com.example.emt_lab2_173115.controller;

import com.example.emt_lab2_173115.entity.Book;
import com.example.emt_lab2_173115.entity.Category;
import com.example.emt_lab2_173115.service.BookService;
import com.example.emt_lab2_173115.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {


    private final BookService bookService;
    private final CategoryService categoryService;

    public BookController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }


    @GetMapping
    public String listBooks(Model model)
    {
        List<Book> books = this.bookService.findAll();
        model.addAttribute("books", books);
        return "books";
    }

    @PostMapping
    public String saveOrUpdateBook(Model model, @Valid Book book, BindingResult bindingResult,  MultipartFile image) throws IOException {
        if(bindingResult.hasErrors())
        {
            List<Category> category = this.categoryService.findAll();
            model.addAttribute("category", category);
            return "books-junior";
        }

        if(book.getId() == null)
        {
            Book newBook =  this.bookService.save(book, image);
        } else {
            this.bookService.update(book.getId(), book, image);
        }
        return "redirect:/books";
    }

    @GetMapping("/add-new")
    public String addNewBook(Model model)
    {
        List<Category> category = this.categoryService.findAll();
        model.addAttribute("books", new Book());
        model.addAttribute("category", category);
        return "books-junior";
    }

    @GetMapping("/{id}/edit")
    public String editBook(@PathVariable Long id, Model model)
    {
        try {
            Book book = this.bookService.findById(id);
            List<Category> category = this.categoryService.findAll();
            model.addAttribute("books", book);
            model.addAttribute("category", category);
            return "books-senior";
        } catch (RuntimeException ex)
        {
            return "redirect:/books?error=" + ex.getLocalizedMessage();
        }
    }

    @PostMapping (value = "/{id}/delete")
    public String deleteBookWithPost(@PathVariable Long id){
        bookService.deleteById(id);
        return "redirect:/books";
    }

}
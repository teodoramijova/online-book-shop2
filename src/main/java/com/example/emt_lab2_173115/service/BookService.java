package com.example.emt_lab2_173115.service;

import com.example.emt_lab2_173115.entity.Book;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BookService {
    List<Book> findAllByCategoryId(Long id);
    List<Book> findAll();
    Book findById(Long id);
    Book save(Book book, MultipartFile image) throws IOException;
    Book update(Long id, Book book, MultipartFile image) throws IOException;
    void deleteById(Long id);
}

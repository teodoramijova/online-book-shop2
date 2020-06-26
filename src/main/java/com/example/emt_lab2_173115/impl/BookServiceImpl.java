package com.example.emt_lab2_173115.impl;

import com.example.emt_lab2_173115.entity.Book;
import com.example.emt_lab2_173115.entity.Category;
import com.example.emt_lab2_173115.exception.BookNotFoundException;
import com.example.emt_lab2_173115.repository.BookRepository;
import com.example.emt_lab2_173115.service.BookService;
import com.example.emt_lab2_173115.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.categoryService = categoryService;
    }


    @Override
    public List<Book> findAllByCategoryId(Long id) {
        return null;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public Book save(Book book, MultipartFile image) throws IOException {
        Category category = this.categoryService.findById(book.getCategory().getId());
        book.setCategory(category);
        if (image != null) {
            byte[] imageBytes = image.getBytes();
            String test = String.format("data:%s;base64,%s", image.getContentType(), Base64.getEncoder().encodeToString(imageBytes));
            book.setBase64Image(test);
        }
        return this.bookRepository.save(book);
    }


    @Override
    public Book update(Long id, Book book, MultipartFile image) throws IOException {
        Book updateBook = this.findById(id);
        Category category = this.categoryService.findById(book.getCategory().getId());
        updateBook.setCategory(category);
        updateBook.setNameBook(book.getNameBook());
        updateBook.setEditionBook(book.getEditionBook());
        updateBook.setPrice(book.getPrice());
        if (image != null) {
            byte[] imageBytes = image.getBytes();
            String test = String.format("data:%s;base64,%s", image.getContentType(), Base64.getEncoder().encodeToString(imageBytes));
            updateBook.setBase64Image(test);
        }
        return this.bookRepository.save(updateBook);
    }


    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }
}

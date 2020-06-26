package com.example.emt_lab2_173115.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id)
    {
        super(String.format("Book with id %d is not found!", id));
    }
}

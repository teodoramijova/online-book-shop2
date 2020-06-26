package com.example.emt_lab2_173115.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.PRECONDITION_FAILED)
public class BookIsAlreadyInShoppingCartException extends RuntimeException {
    public BookIsAlreadyInShoppingCartException(String name) {
        super(String.format("Product %s is alraedy in active shopping cart", name));
    }
}

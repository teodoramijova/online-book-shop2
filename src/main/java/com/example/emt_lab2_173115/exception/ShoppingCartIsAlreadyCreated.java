package com.example.emt_lab2_173115.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
public class ShoppingCartIsAlreadyCreated extends RuntimeException {
    public ShoppingCartIsAlreadyCreated(String username) {
        super(String.format("Shopping cart is already created for user: %s", username));
    }
}

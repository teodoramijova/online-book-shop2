package com.example.emt_lab2_173115.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ActiveShoppingCartAlreadyExists extends RuntimeException{
    public ActiveShoppingCartAlreadyExists() {
        super("ActiveShoppingCartAlreadyExists");
    }
}


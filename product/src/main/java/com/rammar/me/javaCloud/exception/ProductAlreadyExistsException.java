package com.rammar.me.javaCloud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ProductAlreadyExistsException extends Exception{
    public ProductAlreadyExistsException(String name) {
        super("Product with name "+name+" already exists.");
    }
}

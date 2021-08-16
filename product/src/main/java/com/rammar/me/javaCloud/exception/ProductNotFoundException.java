package com.rammar.me.javaCloud.exception;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(Long id) {
        super("Product "+id+" not founded.");
    }
}

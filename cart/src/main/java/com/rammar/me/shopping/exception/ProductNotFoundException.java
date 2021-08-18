package com.rammar.me.shopping.exception;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String productId) {
        super("Product "+productId+" was not found");
    }
}

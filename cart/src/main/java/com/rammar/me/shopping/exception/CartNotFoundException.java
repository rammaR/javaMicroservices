package com.rammar.me.shopping.exception;

public class CartNotFoundException extends Exception {
    public CartNotFoundException(Long id) {
        super("Cart "+id+" not founded");
    }
}

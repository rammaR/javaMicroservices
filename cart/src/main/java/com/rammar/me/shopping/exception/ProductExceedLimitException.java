package com.rammar.me.shopping.exception;

public class ProductExceedLimitException extends Exception {
    public ProductExceedLimitException(String productID, Integer max) {
        super("Product "+productID+" exceed the limit of "+max);
    }
}

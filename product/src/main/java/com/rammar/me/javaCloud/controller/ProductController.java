package com.rammar.me.javaCloud.controller;

import com.rammar.me.javaCloud.exception.ProductAlreadyExistsException;
import com.rammar.me.javaCloud.exception.ProductNotFoundException;
import com.rammar.me.javaCloud.model.Product;
import com.rammar.me.javaCloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable String id) throws ProductNotFoundException {
        return service.findByID(id);
    }

    @GetMapping("/max/{id}")
    public Integer getMaxOfProductId(@PathVariable String id) throws ProductNotFoundException {
        Product product = service.findByID(id);
        return product.getAccount();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) throws ProductAlreadyExistsException {
        return service.save(product);
    }

    @PutMapping("/account/{id}/{decreaseAccount}")
    public Product update(@PathVariable String id, @PathVariable Integer decreaseAccount) throws ProductNotFoundException, ProductAlreadyExistsException {
        return service.updateAccount(id, decreaseAccount);
    }
}

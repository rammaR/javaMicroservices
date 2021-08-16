package com.rammar.me.javaCloud.service;

import com.rammar.me.javaCloud.exception.ProductNotFoundException;
import com.rammar.me.javaCloud.model.Product;
import com.rammar.me.javaCloud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public Product findByID(Long id) throws ProductNotFoundException {
        return repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }
}

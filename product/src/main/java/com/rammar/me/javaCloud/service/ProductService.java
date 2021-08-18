package com.rammar.me.javaCloud.service;

import com.rammar.me.javaCloud.exception.ProductAlreadyExistsException;
import com.rammar.me.javaCloud.exception.ProductNotFoundException;
import com.rammar.me.javaCloud.model.Product;
import com.rammar.me.javaCloud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        Iterator<Product> iterator = repository.findAll().iterator();
        List<Product> list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

    public Product save(Product product) throws ProductAlreadyExistsException {
        if (repository.findByName(product.getName()).size() > 0) {
            throw new ProductAlreadyExistsException(product.getName());
        }

        return repository.save(product);
    }

    public Product findByID(String id) throws ProductNotFoundException {
        return repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    public Product updateAccount(String id, Integer decreaseAccount) throws ProductNotFoundException, ProductAlreadyExistsException {
        Product product = findByID(id);
        product.setAccount(product.getAccount() - decreaseAccount);
        return repository.save(product);
    }
}

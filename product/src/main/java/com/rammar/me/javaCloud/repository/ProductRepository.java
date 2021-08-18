package com.rammar.me.javaCloud.repository;

import com.rammar.me.javaCloud.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
    List<Product> findByName(String name);
}

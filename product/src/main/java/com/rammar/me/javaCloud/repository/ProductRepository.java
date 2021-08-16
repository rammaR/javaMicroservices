package com.rammar.me.javaCloud.repository;

import com.rammar.me.javaCloud.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}

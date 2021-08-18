package com.rammar.me.shopping.service;

import com.rammar.me.shopping.exception.ProductNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    protected String serviceUrl = "http://localhost:8080/product";

    public Integer getProductMax(String productId) throws ProductNotFoundException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Integer> response = restTemplate.getForEntity(serviceUrl + "/max/{id}", Integer.class, productId);
        Integer max = response.getBody();

        if (max == null) {
            throw new ProductNotFoundException(productId);
        } else {
            return max;
        }
    }
}

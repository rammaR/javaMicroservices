package com.rammar.me.shopping.service;

import com.rammar.me.shopping.exception.CartNotFoundException;
import com.rammar.me.shopping.model.Cart;
import com.rammar.me.shopping.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private CartRepository repository;

    public CartService(CartRepository repository){
        this.repository = repository;
    }

    public Cart findById(Long id) throws CartNotFoundException {
        return repository.findById(id).orElse(new Cart());
    }

    public Cart save(Cart cart) {
        return repository.save(cart);
    }

    public void clear(Long id) throws CartNotFoundException {
        Cart cart = findById(id);
        cart.getItems().clear();
    }
}

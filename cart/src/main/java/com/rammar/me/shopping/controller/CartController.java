package com.rammar.me.shopping.controller;

import com.rammar.me.shopping.exception.CartNotFoundException;
import com.rammar.me.shopping.model.Cart;
import com.rammar.me.shopping.model.Item;
import com.rammar.me.shopping.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    private final CartService service;

    public CartController(CartService cartService){
        this.service = cartService;
    }

    @PostMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cart addItem(@PathVariable Long id, @RequestBody Item item) throws CartNotFoundException {
        Cart cart = service.findById(id);
        cart.getItems().add(item);
        return service.save(cart);
    }

    @GetMapping(value = "/{id")
    public Cart getCartById(@PathVariable Long id) throws CartNotFoundException {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void clear(@PathVariable Long id) throws CartNotFoundException {
        service.clear(id);
    }

}

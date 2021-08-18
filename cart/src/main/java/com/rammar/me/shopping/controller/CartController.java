package com.rammar.me.shopping.controller;

import com.rammar.me.shopping.exception.CartNotFoundException;
import com.rammar.me.shopping.exception.ProductExceedLimitException;
import com.rammar.me.shopping.exception.ProductNotFoundException;
import com.rammar.me.shopping.model.Cart;
import com.rammar.me.shopping.model.Item;
import com.rammar.me.shopping.service.CartService;
import com.rammar.me.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartService service;

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cart addItem(@PathVariable String id, @RequestBody Item item) throws CartNotFoundException, ProductNotFoundException, ProductExceedLimitException {
        Integer max = productService.getProductMax(item.getProductID());
        if (item.getQuantity() > max) {
            throw new ProductExceedLimitException(item.getProductID(), max);
        }
        Cart cart = service.findById(id);
        cart.getItems().add(item);
        return service.save(cart);
    }

    @GetMapping(value = "/{id}")
    public Cart getCartById(@PathVariable String id) throws CartNotFoundException {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void clear(@PathVariable String id) throws CartNotFoundException {
        service.clear(id);
    }

}

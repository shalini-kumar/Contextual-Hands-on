package com.sapient.oms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.oms.Entity.Cart;
import com.sapient.oms.Service.CartService;

@RestController
@RequestMapping("/user")
public class CartContoller {
    
    @Autowired
    CartService cartService;
    @GetMapping("/{userId}/cart/{cartId}")
    public Cart getCart(@PathVariable("userId")int userId, @PathVariable("cartId") int cartId){
        Cart cart =cartService.findById(cartId);
        System.out.println(cart);
        return cart;
    }

    @PostMapping("/{userId}/cart-create")
    public String create(@PathVariable("userId") int userId, @RequestBody Cart cart){
        cartService.save(cart);
        return "Cart Created successfully";
    }

}
package com.sapient.oms.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sapient.oms.Entity.CartItem;
import com.sapient.oms.Repository.CartItemRepository;



@Service
public class CartItemService implements ICartItemService{
    @Autowired
    CartItemRepository cartItemRepository;

    @Override
    public CartItem save(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    // @Override
    // public Cart findById(int id) {
    //     return CartRepository.findById(id).orElse(null);
    // }

    @Override
    public void deleteById(Integer id) {
       cartItemRepository.deleteById(id);
    }
    
    public CartItem checkForProductExistance(int productId){
        return cartItemRepository.checkIfProductExists(productId);
    }

    @Override
    public CartItem findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
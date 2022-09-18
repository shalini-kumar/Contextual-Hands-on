package com.sapient.oms.Service;

import com.sapient.oms.Entity.CartItem;

public interface ICartItemService {
    CartItem save(CartItem cartItem);
    CartItem findById(int id);
    void deleteById(Integer id);
}
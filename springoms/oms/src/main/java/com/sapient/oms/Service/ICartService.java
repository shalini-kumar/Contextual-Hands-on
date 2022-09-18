package com.sapient.oms.Service;

import com.sapient.oms.Entity.Cart;

public interface ICartService {
    Cart save(Cart cart);
    void deleteById(Integer id);
    Cart findById(Integer id);
}
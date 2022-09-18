package com.sapient.oms.Repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.oms.Entity.CartItem;


@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Integer>{
    default CartItem checkIfProductExists(int productId){
        List<CartItem> cartItems = findAll();  

        Iterator<CartItem> iteratorCartItems = cartItems.iterator();

        while(iteratorCartItems.hasNext()){
            if(iteratorCartItems.next().getProduct().getId() != productId)
            iteratorCartItems.remove();
        }

        if(cartItems.isEmpty())
            return null;

        return cartItems.get(0);
    }
}
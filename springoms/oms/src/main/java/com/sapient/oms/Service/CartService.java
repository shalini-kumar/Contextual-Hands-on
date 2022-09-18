package com.sapient.oms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.oms.Entity.Cart;
import com.sapient.oms.Entity.CartItem;
import com.sapient.oms.Repository.CartRepository;

@Service
public class CartService implements ICartService{

    @Autowired
    CartItemService cartItemService;

    @Autowired
    CartRepository cartRepository;
    
    @Override
    public void deleteById(Integer id) {
        cartRepository.deleteById(id);
    }

    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart findById(Integer id) {
        return cartRepository.findById(id).orElse(null);
    }
    
    public void addItemToCart(CartItem cartItem, int cartId){
        Cart cart = findById(cartId);

        CartItem availableItems = cartItemService.checkForProductExistance(cartItem.getProduct().getId());
        if(availableItems != null){
            //item exist so increment the quantity
            int newQuantity = availableItems.getQuantity() + 1;
            availableItems.setQuantity(newQuantity);
            cartItemService.save(availableItems);
        }

        else{
            // product doesn't exist
            CartItem newCartItem = cartItemService.save(cartItem);
            List<CartItem> availableCartItems = cart.getCartItems();
            availableCartItems.add(newCartItem);
            cartRepository.save(cart);
        }
    }

    public void decrementItemFromCart(CartItem cartItem, int cartId){
        CartItem availableItems = cartItemService.findById(cartItem.getId());
        int newQuantity = availableItems.getQuantity() - 1;

        if(newQuantity == 0){
            removeItemFromCart(cartItem.getId(), cartId);
        }else{
            availableItems.setQuantity(newQuantity);
            cartItemService.save(availableItems);
        }
    }

    public void removeItemFromCart(int CartItemid, int cartId) {
        Cart cart = findById(cartId);

        if(cart.getCartItems().size() == 1){
            // if items becomes zero which means it doesn't belong to any store
            cart.setStoreId(0);
        }
        cartItemService.deleteById(CartItemid);
    }




}
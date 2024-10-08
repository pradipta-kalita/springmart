package com.springMart.service.cartItem;

import com.springMart.model.CartItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CartItemService implements ICartItemService{
    @Override
    public CartItem addCartItem(UUID cartId, CartItem cartItem) {
        return null;
    }

    @Override
    public CartItem updateCartItem(UUID cartItemId, int quantity) {
        return null;
    }

    @Override
    public void deleteCartItem(UUID cartItemId) {

    }

    @Override
    public CartItem getCartItemById(UUID cartItemId) {
        return null;
    }

    @Override
    public List<CartItem> getAllCartItems(UUID cartId) {
        return List.of();
    }
}

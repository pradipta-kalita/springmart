package com.springMart.service.cartItem;

import com.springMart.model.CartItem;

import java.util.List;
import java.util.UUID;

public interface ICartItemService {
    CartItem addCartItem(UUID cartId, CartItem cartItem);

    CartItem updateCartItem(UUID cartItemId, int quantity);

    void deleteCartItem(UUID cartItemId);

    CartItem getCartItemById(UUID cartItemId);

    List<CartItem> getAllCartItems(UUID cartId);
}

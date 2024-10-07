package com.springMart.service.cart;

import com.springMart.model.Cart;
import com.springMart.model.CartItem;

import java.math.BigDecimal;
import java.util.UUID;

public interface ICartService {
    Cart getCartByCustomerId(UUID customerId);
    Cart addCartItem(UUID customerId, CartItem cartItem);
    Cart updateCartItem(UUID customerId, UUID cartItemId, int quantity);
    Cart removeCartItem(UUID customerId, UUID cartItemId);
    void clearCart(UUID customerId);
    BigDecimal calculateCartTotal(UUID customerId);
}

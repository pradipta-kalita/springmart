package com.springMart.service.cart;

import com.springMart.model.Cart;
import com.springMart.model.CartItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@Transactional
public class CartService implements ICartService{
    @Override
    public Cart getCartByCustomerId(UUID customerId) {
        return null;
    }

    @Override
    public Cart addCartItem(UUID customerId, CartItem cartItem) {
        return null;
    }

    @Override
    public Cart updateCartItem(UUID customerId, UUID cartItemId, int quantity) {
        return null;
    }

    @Override
    public Cart removeCartItem(UUID customerId, UUID cartItemId) {
        return null;
    }

    @Override
    public void clearCart(UUID customerId) {

    }

    @Override
    public BigDecimal calculateCartTotal(UUID customerId) {
        return null;
    }
}

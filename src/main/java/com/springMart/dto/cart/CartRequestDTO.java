package com.springMart.dto.cart;

import com.springMart.model.CartItem;
import com.springMart.model.Customer;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class CartRequestDTO {

    private UUID id;

    private Customer customer;

    private Set<CartItem> cartItems;

    private BigDecimal totalPrice;

}

package com.springMart.repository;

import com.springMart.model.Cart;
import com.springMart.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, UUID> {
}

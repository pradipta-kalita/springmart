package com.springMart.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private Set<CartItem> cartItems= new HashSet<>();

    @Column(name = "total_price",nullable = false)
    private BigDecimal totalPrice;

    // Calculate total price based on items in the cart
    public Double calculateTotalPrice(){
        return cartItems.stream().mapToDouble(item->item.getPrice()*item.getQuantity()).sum();
    }

    // Another way of doing it
    /*
     public double calculateTotalPrice() {
          return cartItems.stream()
                  .mapToDouble(CartItem::getTotalItemPrice)
                  .sum();
      }
    */

}

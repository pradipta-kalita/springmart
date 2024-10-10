package com.springMart.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    // One-to-One relation with Customer Entity
    @NotBlank(message = "Customer id is required.")
    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    // One-to-Many relation with CartItem Entity
    @JsonManagedReference
    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private Set<CartItem> cartItems= new HashSet<>();

    @Column(name = "total_price",nullable = false)
    private BigDecimal totalPrice;

    // Calculate total price based on items in the cart
    public BigDecimal calculateTotalPrice() {
        return cartItems.stream()
                .map(item ->item.getPrice().multiply(new BigDecimal(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @PrePersist
    @PreUpdate
    protected void onUpdate(){
        this.totalPrice=calculateTotalPrice();
    }
}

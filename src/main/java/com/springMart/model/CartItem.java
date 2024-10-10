package com.springMart.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @PositiveOrZero(message = "Quantity should be 0 or more than that.")
    @NotNull(message = "Quantity cannot be null")
    @Column(name = "quantity",nullable = false)
    private int quantity;

    @PositiveOrZero(message = "Price cannot be less than 0.")
    @NotNull(message = "Price cannot be null.")
    @Column(name = "price",nullable = false)
    private BigDecimal price;

    // Many-to-One relation with Cart Entity
    @NotBlank(message = "Cart id is required.")
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cart_id",nullable = false)
    private Cart cart;

    // Many-to-One relation with Product Entity
    @JsonBackReference
    @NotBlank(message = "Product id is required.")
    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    public BigDecimal getTotalItemPrice() {
        return this.price.multiply(new BigDecimal(this.quantity));
    }
}

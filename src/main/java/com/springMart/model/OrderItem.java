package com.springMart.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.springMart.model.order.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @PositiveOrZero(message = "Quantity should be 0 or more than 0.")
    @NotNull(message = "Quantity is required.")
    @Column(name = "quantity",nullable = false)
    private int quantity;

    @PositiveOrZero(message = "Price should be 0 or more than that.")
    @NotNull(message = "Price is required")
    @Column(name = "price",nullable = false)
    private BigDecimal price;

    // Many-to-One relation with Order Entity
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;

    // Many-to-One relation with Product Entity
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    public BigDecimal getTotalItemPrice(){
        return this.price.multiply(new BigDecimal(this.quantity));
    }
}

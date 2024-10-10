package com.springMart.model.order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springMart.model.Customer;
import com.springMart.model.OrderItem;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "order_date",nullable = false)
    private LocalDateTime orderDate;

    @NotBlank(message = "status is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
    private OrderStatus status;

    @PositiveOrZero
    @Column(name = "total_amount",nullable = false)
    private BigDecimal totalAmount;

    // One-to-Many relation with OrderItem Entity
    @JsonManagedReference
    @NotEmpty(message = "Order must contain at least one item")
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<OrderItem> orderItems = new HashSet<>();

    // Many-to-One relation with Customer
    @JsonBackReference
    @NotBlank(message = "Customer id is required.")
    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @PrePersist
    protected void onCreate() {
        this.orderDate = LocalDateTime.now();
        this.status = OrderStatus.PENDING;
        this.totalAmount=calculateTotalAmount();
    }

    @PreUpdate
    protected void onUpdate(){
        this.totalAmount=calculateTotalAmount();
    }

    public BigDecimal calculateTotalAmount(){
        return orderItems.stream().
                map(OrderItem::getTotalItemPrice).
                reduce(BigDecimal.ZERO,BigDecimal::add);
    }


}


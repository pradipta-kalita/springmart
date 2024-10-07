package com.springMart.model;

import jakarta.persistence.*;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
    private OrderStatus status;

    @Column(name = "total_amount",nullable = false)
    private BigDecimal totalAmount;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<OrderItem> orderItems = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @PrePersist
    protected void onCreate() {
        this.orderDate = LocalDateTime.now();
        this.status = OrderStatus.PENDING;
    }

    public BigDecimal calculateTotalAmount(){
        return orderItems.stream().
                map(OrderItem::getTotalItemPrice).
                reduce(BigDecimal.ZERO,BigDecimal::add);
    }
}

enum OrderStatus{
    PENDING,SHIPPED,DELIVERED
}
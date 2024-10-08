package com.springMart.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name",nullable = false,length = 200)
    private String name;

    @Lob
    @Column(name = "description",nullable = false)
    private String description;


    @Column(name = "price",nullable = false,precision = 12, scale = 2)
    private BigDecimal price;

    @Column(name = "inventory",nullable = false)
    private int inventory;

    @Column(name = "created_at",updatable = false)
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    // One-to-Many relationship with Image Entity
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Image> images= new HashSet<>();

    // One-to-Many relationship with OrderItem
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<OrderItem> orderItems = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    @PrePersist
    protected void onCreate(){
        createdAt=LocalDate.now();
    }

    @PreUpdate
    protected  void onUpdate(){
        updatedAt=LocalDate.now();
    }
}

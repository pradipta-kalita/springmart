package com.springMart.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springMart.model.order.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "First name is required.")
    @Size(max = 50, min = 3, message = "First name should include at least 3 letters and at most 50.")
    @Pattern(regexp = "^[a-zA-Z]+$")
    @Column(name = "first_name", nullable = false)
    private String firstName;


    @NotBlank(message = "Last name is required.")
    @Size(max = 50, min = 3, message = "Last name should include at least 3 letters and at most 50.")
    @Pattern(regexp = "^[a-zA-Z]+$")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotBlank(message = "Email is required.")
    @Email(message = "Email is not valid")
    @Size(max = 50, message = "Email is too long.")
    @Column(name = "email",unique = true,nullable = false)
    private String email;

    @NotNull(message = "Phone number is required.")
    @Column(name = "phone_number",nullable = false)
    private Long phoneNumber;

    @NotNull(message = "Address is required.")
    @Size(min = 3,max = 100,message = "Address should include at least 3 letters and at most 100.")
    @Column(name = "address",nullable = false)
    private String address;

    // One-to-Many relationship with Customer Entity
    @JsonManagedReference
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Order> orders = new HashSet<>();

    // One-to-One relationship with Cart Entity
    @JsonManagedReference
    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Cart cart;
}

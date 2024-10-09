package com.springMart.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Locale;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @NotBlank(message = "Category cannot be blank.")
    @Size(max = 50, message = "Name should be at most 50 characters long.")
    @Column(name = "name",nullable = false,length = 50)
    private String name;

    @NotBlank(message = "Category description cannot be blank.")
    @Size(max = 50,message = "Description should be at most 50 characters long.")
    @Column(name = "description",length = 50)
    private String description;

    @Column(name = "slug", unique = true)
    private String slug;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Product> products;

    @PrePersist
    @PreUpdate
    public void updateSlug() {
        this.slug = generateSlug(this.name);
    }

    private String generateSlug(String name) {
        return name
                .trim()
                .toLowerCase(Locale.ROOT)
                .replaceAll("[^a-z0-9]+", "-")
                .replaceAll("-{2,}", "-")
                .replaceAll("(^-|-$)", "");
    }
}

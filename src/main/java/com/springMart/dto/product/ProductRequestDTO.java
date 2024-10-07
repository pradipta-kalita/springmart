package com.springMart.dto.product;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class ProductRequestDTO {

    @NotBlank(message = "Product name is required")
    private String name;

    @NotBlank(message = "Product description is required")
    private String description;

    @NotNull(message = "Product price is required")
    @Digits(integer = 10, fraction = 2, message = "Price should be reasonable")
    private BigDecimal price;

    @NotNull(message = "Inventory count is required")
    private Integer inventory;

    private Set<UUID> images;
}

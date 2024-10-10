package com.springMart.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class ProductRequestDTO {
    @NotBlank(message = "Product name is required.")
    @Size(min = 1,max = 200,message = "Name should be at least 3 characters long and maximum 200.")
    private String name;

    @NotBlank(message = "Product description is required.")
    private String description;

    @NotNull(message = "Price is required")
    @PositiveOrZero(message = "Product price should be at least 0 or more than that.")
    @Digits(integer = 10,fraction = 2)
    private BigDecimal price;

    @NotNull(message = "Inventory cannot be null.")
    @PositiveOrZero(message = "Inventory should be at least 0 or more than that.")
    private int inventory;

    @NotNull(message = "Category ID is required")
    private UUID categoryId;

    private MultipartFile[] images;
}

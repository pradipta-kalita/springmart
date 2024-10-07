package com.springMart.dto.category;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequestDTO {

    @NotNull(message = "Category name is required")
    private String name;

    private String description;
}

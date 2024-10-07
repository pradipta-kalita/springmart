package com.springMart.dto.product;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public class ProductResponseDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer inventory;
    private Set<UUID> images;
}

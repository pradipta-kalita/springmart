package com.springMart.dto.order;

import java.util.List;
import java.util.UUID;

public class OrderRequestDTO {
    private UUID customerId;
    private List<UUID> productIds;
}

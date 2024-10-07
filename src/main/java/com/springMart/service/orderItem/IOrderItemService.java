package com.springMart.service.orderItem;

import com.springMart.model.OrderItem;

import java.util.UUID;

public interface IOrderItemService {
    OrderItem addOrderItem(UUID orderId, OrderItem orderItem);
    OrderItem updateOrderItem(UUID orderItemId, OrderItem orderItem);
    void deleteOrderItem(UUID orderItemId);
    OrderItem getOrderItemById(UUID orderItemId);
}

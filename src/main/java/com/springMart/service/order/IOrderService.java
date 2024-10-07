package com.springMart.service.order;

import com.springMart.model.Order;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface IOrderService {
    Order createOrder(Order order);
    Order getOrderById(UUID orderId);
    Order updateOrderById(UUID orderId,Order order);
    void deleteOrderById(UUID orderId);

    List<Order> getAllOrders();
    List<Order> getOrdersByCustomerId(UUID customerId);
    BigDecimal calculateTotalAmount(UUID orderId);
}

package com.springMart.service.order;

import com.springMart.model.order.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class OrderService implements IOrderService{
    @Override
    public Order createOrder(Order order) {
        return null;
    }

    @Override
    public Order getOrderById(UUID orderId) {
        return null;
    }

    @Override
    public Order updateOrderById(UUID orderId, Order order) {
        return null;
    }

    @Override
    public void deleteOrderById(UUID orderId) {

    }

    @Override
    public List<Order> getAllOrders() {
        return List.of();
    }

    @Override
    public List<Order> getOrdersByCustomerId(UUID customerId) {
        return List.of();
    }

    @Override
    public BigDecimal calculateTotalAmount(UUID orderId) {
        return null;
    }
}

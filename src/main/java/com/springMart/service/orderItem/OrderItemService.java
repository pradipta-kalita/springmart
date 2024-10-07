package com.springMart.service.orderItem;

import com.springMart.model.OrderItem;
import com.springMart.repository.OrderItemRepository;
import com.springMart.repository.OrderRepository;
import com.springMart.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class OrderItemService implements IOrderItemService{
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderItemService(OrderItemRepository orderItemRepository, OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public OrderItem addOrderItem(UUID orderId, OrderItem orderItem) {
        return null;
    }

    @Override
    public OrderItem updateOrderItem(UUID orderItemId, OrderItem orderItem) {
        return null;
    }

    @Override
    public void deleteOrderItem(UUID orderItemId) {

    }

    @Override
    public OrderItem getOrderItemById(UUID orderItemId) {
        return null;
    }
}

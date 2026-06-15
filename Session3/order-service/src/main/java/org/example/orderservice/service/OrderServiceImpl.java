package org.example.orderservice.service;

import lombok.RequiredArgsConstructor;
import org.example.orderservice.dto.Reponse.OrderResponseDTO;
import org.example.orderservice.dto.Request.OrderRequestDTO;
import org.example.orderservice.entity.Order;
import org.example.orderservice.exception.ResourceNotFoundException;
import org.example.orderservice.repository.OrderRepository;
import org.example.orderservice.service.impl.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    @Override
    public OrderResponseDTO createOrder(OrderRequestDTO dto) {

        if (dto.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        double productPrice = 100000.0;

        Order order = new Order();

        order.setCustomerId(dto.getCustomerId());
        order.setProductId(dto.getProductId());
        order.setOrderDate(LocalDateTime.now());

        order.setTotalAmount(productPrice * dto.getQuantity());

        repository.save(order);

        return map(order);
    }

    @Override
    public OrderResponseDTO getOrder(Long id) {

        Order order = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));

        return map(order);
    }

    private OrderResponseDTO map(Order order) {

        OrderResponseDTO dto = new OrderResponseDTO();

        dto.setId(order.getId());
        dto.setCustomerId(order.getCustomerId());
        dto.setProductId(order.getProductId());
        dto.setOrderDate(order.getOrderDate());
        dto.setTotalAmount(order.getTotalAmount());

        return dto;
    }
}
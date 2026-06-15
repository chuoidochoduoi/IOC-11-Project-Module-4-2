package org.example.orderservice.service.impl;

import org.example.orderservice.dto.Reponse.OrderResponseDTO;
import org.example.orderservice.dto.Request.OrderRequestDTO;

public interface OrderService {

    OrderResponseDTO createOrder(OrderRequestDTO dto);

    OrderResponseDTO getOrder(Long id);
}
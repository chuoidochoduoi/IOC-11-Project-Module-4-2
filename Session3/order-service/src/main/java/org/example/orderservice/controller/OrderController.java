package org.example.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.orderservice.dto.Reponse.OrderResponseDTO;
import org.example.orderservice.dto.Request.OrderRequestDTO;
import org.example.orderservice.service.impl.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping
    public OrderResponseDTO create( @RequestBody OrderRequestDTO dto) {

        return service.createOrder(dto);
    }

    @GetMapping("/{id}")
    public OrderResponseDTO getById(@PathVariable Long id) {

        return service.getOrder(id);
    }
}
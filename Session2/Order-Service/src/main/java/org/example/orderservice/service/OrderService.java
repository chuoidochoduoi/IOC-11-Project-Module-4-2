package org.example.orderservice.service;
import org.example.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public String getHealthCheckMessage() {
        return "Order Service is Up";
    }
}

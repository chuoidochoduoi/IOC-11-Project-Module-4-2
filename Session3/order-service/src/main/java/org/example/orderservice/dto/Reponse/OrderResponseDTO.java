package org.example.orderservice.dto.Reponse;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderResponseDTO {

    private Long id;

    private Long customerId;

    private Long productId;

    private LocalDateTime orderDate;

    private Double totalAmount;
}

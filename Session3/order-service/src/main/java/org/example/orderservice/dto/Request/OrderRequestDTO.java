package org.example.orderservice.dto.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDTO {

    private Long customerId;

    private Long productId;

    private Integer quantity;
}
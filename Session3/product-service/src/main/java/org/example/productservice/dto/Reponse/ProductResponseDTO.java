package org.example.productservice.dto.Reponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {

    private Long id;
    private String name;
    private Double price;
    private Integer stockQuantity;
}
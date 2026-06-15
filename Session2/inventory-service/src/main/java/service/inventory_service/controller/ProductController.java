package service.inventory_service.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.inventory_service.dto.ProductResponseDTO;
import service.inventory_service.entity.Product;
import service.inventory_service.entity.ProductEntity;
import service.inventory_service.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;
    @GetMapping("/bai1")
    public ProductResponseDTO getProduct() {

        ProductEntity product = new ProductEntity(
                1L,
                "Laptop Dell",
                "DELL001",
                12000000.0,
                15000000.0,
                50
        );

        ProductResponseDTO response = new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getSellPrice()
        );

        return response;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}

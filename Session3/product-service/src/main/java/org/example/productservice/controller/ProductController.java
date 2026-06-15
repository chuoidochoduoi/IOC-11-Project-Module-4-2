package org.example.productservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.productservice.dto.Reponse.ProductResponseDTO;
import org.example.productservice.dto.Request.ProductRequestDTO;
import org.example.productservice.service.iml.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ProductResponseDTO create(@RequestBody ProductRequestDTO dto) {

        return service.create(dto);
    }

    @GetMapping("/{id}")
    public ProductResponseDTO getById(
            @PathVariable Long id) {

        return service.getById(id);
    }

    @GetMapping
    public List<ProductResponseDTO> getAll() {

        return service.getAll();
    }
}
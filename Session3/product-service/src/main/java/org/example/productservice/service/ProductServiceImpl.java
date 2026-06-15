package org.example.productservice.service;

import lombok.RequiredArgsConstructor;
import org.example.productservice.dto.Reponse.ProductResponseDTO;
import org.example.productservice.dto.Request.ProductRequestDTO;
import org.example.productservice.entity.Product;
import org.example.productservice.exception.ResourceNotFoundException;
import org.example.productservice.repository.ProductRepository;
import org.example.productservice.service.iml.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public ProductResponseDTO create(ProductRequestDTO dto) {

        Product product = new Product();

        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStockQuantity(dto.getStockQuantity());

        repository.save(product);

        return map(product);
    }

    @Override
    public ProductResponseDTO getById(Long id) {

        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));

        return map(product);
    }

    @Override
    public List<ProductResponseDTO> getAll() {

        return repository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    private ProductResponseDTO map(Product product) {

        ProductResponseDTO dto = new ProductResponseDTO();

        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setStockQuantity(product.getStockQuantity());

        return dto;
    }
}

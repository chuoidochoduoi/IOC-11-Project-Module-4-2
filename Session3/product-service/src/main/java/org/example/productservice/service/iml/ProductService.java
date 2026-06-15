package org.example.productservice.service.iml;

import org.example.productservice.dto.Reponse.ProductResponseDTO;
import org.example.productservice.dto.Request.ProductRequestDTO;

import java.util.List;

public interface ProductService {

    ProductResponseDTO create(ProductRequestDTO dto);

    ProductResponseDTO getById(Long id);

    List<ProductResponseDTO> getAll();
}

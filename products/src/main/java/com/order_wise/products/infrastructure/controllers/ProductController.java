package com.order_wise.products.infrastructure.controllers;

import com.order_wise.products.application.dto.ProductRequestDTO;
import com.order_wise.products.application.dto.ProductResponseDTO;
import com.order_wise.products.application.usecases.CreateProductUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final CreateProductUseCase createProductUseCase;

    public ProductController(CreateProductUseCase createProductUseCase) {
        this.createProductUseCase = createProductUseCase;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody @Valid ProductRequestDTO productRequestDTO){
        ProductResponseDTO response = createProductUseCase.execute(productRequestDTO);
        return ResponseEntity.ok(response);
    }
}

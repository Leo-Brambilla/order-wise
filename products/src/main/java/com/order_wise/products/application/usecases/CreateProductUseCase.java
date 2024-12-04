package com.order_wise.products.application.usecases;

import com.order_wise.products.application.dto.ProductRequestDTO;
import com.order_wise.products.application.dto.ProductResponseDTO;
import com.order_wise.products.domain.entities.Product;
import com.order_wise.products.domain.repositories.ProductRepository;
import org.springframework.util.ObjectUtils;

public class CreateProductUseCase {

    private final ProductRepository productRepository;

    public CreateProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDTO execute (ProductRequestDTO productRequestDTO){
        var productFounded = productRepository.findByBarcode(productRequestDTO.getBarCode());

        if(ObjectUtils.isEmpty(productFounded)){
            Product product = new Product(productRequestDTO.getProductName(), productRequestDTO.getBarCode(), productRequestDTO.getStorageAmount(),
                    productRequestDTO.getFullPrice());
            Product productSaved = productRepository.save(product);

            return new ProductResponseDTO(productSaved.getProductId(), productSaved.getProductName(), productSaved.getBarCode(), productSaved.getStorageAmount(),
                    productSaved.getFullPrice(), productSaved.getProductIsActive());
        }
        return productFounded;
    }
}

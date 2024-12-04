package com.order_wise.products.domain.repositories;

import com.order_wise.products.application.dto.ProductResponseDTO;
import com.order_wise.products.domain.entities.Product;

public interface ProductRepository {
    ProductResponseDTO findByBarcode(String barCode);
    Product save(Product product);
}

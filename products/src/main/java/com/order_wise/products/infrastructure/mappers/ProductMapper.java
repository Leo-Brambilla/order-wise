package com.order_wise.products.infrastructure.mappers;

import com.order_wise.products.domain.entities.Product;
import com.order_wise.products.infrastructure.persistence.ProductEntity;

public class ProductMapper {

    public static ProductEntity toEntity(Product product){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductId(product.getProductId());
        productEntity.setProductName(product.getProductName());
        productEntity.setBarCode(product.getBarCode());
        productEntity.setStorageAmount(product.getStorageAmount());
        productEntity.setFullPrice(product.getFullPrice());
        productEntity.setProductIsActive(product.getProductIsActive());
        productEntity.setCreatedAt(product.getCreatedAt());
        productEntity.setUpdatedAt(product.getUpdatedAt());
        return productEntity;
    }

    public static Product toDomain(ProductEntity productEntity){
        return new Product(
                productEntity.getProductId(),
                productEntity.getProductName(),
                productEntity.getBarCode(),
                productEntity.getStorageAmount(),
                productEntity.getFullPrice(),
                productEntity.getProductIsActive(),
                productEntity.getCreatedAt(),
                productEntity.getUpdatedAt());
    }

}

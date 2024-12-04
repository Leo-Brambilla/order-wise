package com.order_wise.products.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataProductRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findByBarcode(String barCode);
}

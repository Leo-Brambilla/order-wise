package com.order_wise.products.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(nullable = false)
    private String productName;
    @Column(nullable = false, unique = true)
    private String barCode;
    private Integer storageAmount;
    private Double fullPrice;
    private Boolean productIsActive = true;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}

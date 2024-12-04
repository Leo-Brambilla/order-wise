package com.order_wise.products.domain.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class Product {

    private Long productId;
    private String productName;
    private String barCode;
    private Integer storageAmount;
    private Double fullPrice;
    private Boolean productIsActive = true;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Product(Long productId, String productName, String barCode, Integer storageAmount, Double fullPrice, Boolean productIsActive, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.productId = productId;
        this.productName = productName;
        this.barCode = barCode;
        this.storageAmount = storageAmount;
        this.fullPrice = fullPrice;
        this.productIsActive = productIsActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Product(String productName, String barCode, Integer storageAmount, Double fullPrice) {
        this.productName = productName;
        this.barCode = barCode;
        this.storageAmount = storageAmount;
        this.fullPrice = fullPrice;
        this.productIsActive = Boolean.TRUE;
        this.createdAt = LocalDateTime.now();
    }

    public void inactivate() {
        this.productIsActive = false;
        this.updatedAt = LocalDateTime.now();
    }

    public void update(String name, String barCode, Integer storageAmount, Double fullPrice) {
        this.productName = name;
        this.barCode = barCode;
        this.storageAmount = storageAmount;
        this.fullPrice = fullPrice;
        this.updatedAt = LocalDateTime.now();
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getBarCode() {
        return barCode;
    }

    public Integer getStorageAmount() {
        return storageAmount;
    }

    public Double getFullPrice() {
        return fullPrice;
    }

    public Boolean getProductIsActive() {
        return productIsActive;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(barCode, product.barCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barCode);
    }
}

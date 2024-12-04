package com.order_wise.products.application.dto;

public class ProductResponseDTO {

    private Long productId;
    private String productName;
    private String barCode;
    private Integer storageAmount;
    private Double fullPrice;
    private Boolean productIsActive = true;

    public ProductResponseDTO(Long productId, String productName, String barCode, Integer storageAmount, Double fullPrice, Boolean productIsActive) {
        this.productId = productId;
        this.productName = productName;
        this.barCode = barCode;
        this.storageAmount = storageAmount;
        this.fullPrice = fullPrice;
        this.productIsActive = productIsActive;
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
}

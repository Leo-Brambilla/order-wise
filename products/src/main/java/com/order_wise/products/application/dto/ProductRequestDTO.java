package com.order_wise.products.application.dto;

import jakarta.validation.constraints.NotBlank;

public class ProductRequestDTO {

    @NotBlank(message = "Name cannot be blank")
    private String productName;

    @NotBlank(message = "Barcode cannot be blank")
    private String barCode;

    @NotBlank(message = "Amount cannot be blank")
    private Integer storageAmount;

    @NotBlank(message = "The total price cannot be blank")
    private Double fullPrice;

    public ProductRequestDTO(String productName, String barCode, Integer storageAmount, Double fullPrice) {
        this.productName = productName;
        this.barCode = barCode;
        this.storageAmount = storageAmount;
        this.fullPrice = fullPrice;
    }

    public @NotBlank(message = "Name cannot be blank") String getProductName() {
        return productName;
    }

    public void setProductName(@NotBlank(message = "Name cannot be blank") String productName) {
        this.productName = productName;
    }

    public @NotBlank(message = "Barcode cannot be blank") String getBarCode() {
        return barCode;
    }

    public void setBarCode(@NotBlank(message = "Barcode cannot be blank") String barCode) {
        this.barCode = barCode;
    }

    public @NotBlank(message = "Amount cannot be blank") Integer getStorageAmount() {
        return storageAmount;
    }

    public void setStorageAmount(@NotBlank(message = "Amount cannot be blank") Integer storageAmount) {
        this.storageAmount = storageAmount;
    }

    public @NotBlank(message = "The total price cannot be blank") Double getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(@NotBlank(message = "The total price cannot be blank") Double fullPrice) {
        this.fullPrice = fullPrice;
    }
}

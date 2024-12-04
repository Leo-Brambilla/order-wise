package com.order_wise.products.application.dto;

import jakarta.validation.constraints.NotBlank;

public class ProductUpdateDTO {

    @NotBlank(message = "Name cannot be blank")
    private String productName;

    @NotBlank(message = "Amount cannot be blank")
    private Integer storageAmount;

    @NotBlank(message = "The total price cannot be blank")
    private Double fullPrice;

    private Boolean productIsActive;

    public ProductUpdateDTO(String productName, Integer storageAmount, Double fullPrice, Boolean productIsActive) {
        this.productName = productName;
        this.storageAmount = storageAmount;
        this.fullPrice = fullPrice;
        this.productIsActive = productIsActive;
    }

    public @NotBlank(message = "Name cannot be blank") String getProductName() {
        return productName;
    }

    public void setProductName(@NotBlank(message = "Name cannot be blank") String productName) {
        this.productName = productName;
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

    public Boolean getProductIsActive() {
        return productIsActive;
    }

    public void setProductIsActive(Boolean productIsActive) {
        this.productIsActive = productIsActive;
    }
}

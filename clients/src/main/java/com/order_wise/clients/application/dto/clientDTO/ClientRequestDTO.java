package com.order_wise.clients.application.dto.clientDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClientRequestDTO {

    @NotBlank
    private String userName;

    @NotBlank
    private String userDocument;

    @NotBlank
    private String userPassword;

    @NotBlank
    private String addressStreet;

    @NotBlank
    private String addressNumber;

    @NotBlank
    private String addressCity;

    @NotBlank
    private String addressState;

    @NotNull
    private Integer loyaltyPoints;

    @NotNull
    private Long preferredPaymentMethodId;

    public ClientRequestDTO() {
    }

    public ClientRequestDTO(String userName, String userDocument, String userPassword, String addressStreet, String addressNumber, String addressCity, String addressState, Integer loyaltyPoints, Long preferredPaymentMethodId) {
        this.userName = userName;
        this.userDocument = userDocument;
        this.userPassword = userPassword;
        this.addressStreet = addressStreet;
        this.addressNumber = addressNumber;
        this.addressCity = addressCity;
        this.addressState = addressState;
        this.loyaltyPoints = loyaltyPoints;
        this.preferredPaymentMethodId = preferredPaymentMethodId;
    }

    public @NotBlank String getUserName() {
        return userName;
    }

    public void setUserName(@NotBlank String userName) {
        this.userName = userName;
    }

    public @NotBlank String getUserDocument() {
        return userDocument;
    }

    public void setUserDocument(@NotBlank String userDocument) {
        this.userDocument = userDocument;
    }

    public @NotBlank String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(@NotBlank String userPassword) {
        this.userPassword = userPassword;
    }

    public @NotBlank String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(@NotBlank String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public @NotBlank String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(@NotBlank String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public @NotBlank String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(@NotBlank String addressCity) {
        this.addressCity = addressCity;
    }

    public @NotBlank String getAddressState() {
        return addressState;
    }

    public void setAddressState(@NotBlank String addressState) {
        this.addressState = addressState;
    }

    public @NotNull Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(@NotNull Integer loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public @NotNull Long getPreferredPaymentMethodId() {
        return preferredPaymentMethodId;
    }

    public void setPreferredPaymentMethodId(@NotNull Long preferredPaymentMethodId) {
        this.preferredPaymentMethodId = preferredPaymentMethodId;
    }
}

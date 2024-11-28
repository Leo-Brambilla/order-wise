package com.order_wise.clients.application.dto.clientDTO;

public class ClientResponseDTO {

    private Long clientId;
    private String userName;
    private String userDocument;
    private Integer loyaltyPoints;
    private Long preferredPaymentMethodId;
    private String addressStreet;
    private String addressCity;

    public ClientResponseDTO(
            Long clientId, String userName, String userDocument,
            Integer loyaltyPoints, Long preferredPaymentMethodId,
            String addressStreet, String addressCity) {
        this.clientId = clientId;
        this.userName = userName;
        this.userDocument = userDocument;
        this.loyaltyPoints = loyaltyPoints;
        this.preferredPaymentMethodId = preferredPaymentMethodId;
        this.addressStreet = addressStreet;
        this.addressCity = addressCity;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDocument() {
        return userDocument;
    }

    public void setUserDocument(String userDocument) {
        this.userDocument = userDocument;
    }

    public Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(Integer loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public Long getPreferredPaymentMethodId() {
        return preferredPaymentMethodId;
    }

    public void setPreferredPaymentMethodId(Long preferredPaymentMethodId) {
        this.preferredPaymentMethodId = preferredPaymentMethodId;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }
}

package com.order_wise.clients.application.dto.clientDTO;

public class ClientUpdateDTO {

    private String name;
    private Integer loyaltyPoints;
    private Long preferredPaymentMethodId;
    private String addressStreet;
    private String addressCity;

    public ClientUpdateDTO() {
    }

    public ClientUpdateDTO(String name, Integer loyaltyPoints, Long preferredPaymentMethodId, String addressStreet, String addressCity) {
        this.name = name;
        this.loyaltyPoints = loyaltyPoints;
        this.preferredPaymentMethodId = preferredPaymentMethodId;
        this.addressStreet = addressStreet;
        this.addressCity = addressCity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

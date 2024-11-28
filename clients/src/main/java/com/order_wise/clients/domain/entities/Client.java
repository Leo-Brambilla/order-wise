package com.order_wise.clients.domain.entities;

import java.util.List;
import java.util.Objects;

public class Client {
    private Long id;
    private Long userId;
    private List<Long> addressIds;
    private Long loyaltyPoints;
    private Long preferredPaymentMethodId;

    public Client(Long id, Long userId, List<Long> addressIds, Long loyaltyPoints, Long preferredPaymentMethodId) {
        this.id = id;
        this.userId = userId;
        this.addressIds = addressIds;
        this.loyaltyPoints = loyaltyPoints;
        this.preferredPaymentMethodId = preferredPaymentMethodId;
    }

    public void addLoyaltyPoints(Long points) {
        this.loyaltyPoints += points;
    }

    public void setPreferredPaymentMethod(Long paymentMethodId) {
        this.preferredPaymentMethodId = paymentMethodId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getAddressIds() {
        return addressIds;
    }

    public void setAddressIds(List<Long> addressIds) {
        this.addressIds = addressIds;
    }

    public Long getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(Long loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public Long getPreferredPaymentMethodId() {
        return preferredPaymentMethodId;
    }

    public void setPreferredPaymentMethodId(Long preferredPaymentMethodId) {
        this.preferredPaymentMethodId = preferredPaymentMethodId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

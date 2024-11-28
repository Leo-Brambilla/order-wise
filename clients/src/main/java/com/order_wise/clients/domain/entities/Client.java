package com.order_wise.clients.domain.entities;

import java.util.Objects;

public class Client {
    private Long id;
    private Integer loyaltyPoints;
    private Long preferredPaymentMethodId;
    private Address address;
    private User user;

    public Client(Long id, Integer loyaltyPoints, Long preferredPaymentMethodId, Address address, User user) {
        this.id = id;
        this.loyaltyPoints = loyaltyPoints;
        this.preferredPaymentMethodId = preferredPaymentMethodId;
        this.address = address;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public Long getPreferredPaymentMethodId() {
        return preferredPaymentMethodId;
    }

    public Address getAddress() {
        return address;
    }

    public User getUser() {
        return user;
    }

    public void update(String name, Integer loyaltyPoints, Long preferredPaymentMethodId, Address address) {
        if (this.user != null) {
            this.user.update(name, this.user.getPassword());
        }
        this.loyaltyPoints = loyaltyPoints;
        this.preferredPaymentMethodId = preferredPaymentMethodId;
        this.address = address;
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
        return Objects.hash(id);
    }
}

package com.order_wise.clients.domain.entities;

import java.util.Objects;

public class Client {
    private Long id;
    private Integer loyaltyPoints;
    private boolean isActive;
    private Address address;
    private User user;

    public Client(Long id, Integer loyaltyPoints, boolean isActive, Address address, User user) {
        validateLoyaltyPoints(loyaltyPoints);
        validateUser(user);
        validateAddress(address);
        this.id = id;
        this.loyaltyPoints = loyaltyPoints;
        this.isActive = isActive;
        this.address = address;
        this.user = user;
    }

    public Client(User user, Address address) {
        validateUser(user);
        validateAddress(address);
        this.loyaltyPoints = 0;
        this.isActive = false;
        this.user = user;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(Integer loyaltyPoints) {
        validateLoyaltyPoints(loyaltyPoints);
        this.loyaltyPoints = loyaltyPoints;
    }

    public boolean isActive() {
        return isActive;
    }

    public void activate() {
        if (this.address == null) {
            throw new IllegalStateException("Cannot activate client without an address.");
        }
        if (this.user.getIsActive()) {
            throw new IllegalStateException("Cannot activate client with an inactive user.");
        }
        this.isActive = true;
    }

    public void deactivate() {
        this.isActive = false;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        validateUser(user);
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        validateAddress(address);
        this.address = address;
    }

    public void update(String name, String email, Integer loyaltyPoints, Address address) {
        if (this.user != null) {
            this.user.update(name, email, this.user.getPassword());
        }
        setLoyaltyPoints(loyaltyPoints);
        setAddress(address);
    }

    public void addLoyaltyPoints(int points) {
        if (points < 0) {
            throw new IllegalArgumentException("Points cannot be negative.");
        }
        this.loyaltyPoints += points;
    }

    private void validateLoyaltyPoints(Integer loyaltyPoints) {
        if (loyaltyPoints == null || loyaltyPoints < 0) {
            throw new IllegalArgumentException("Loyalty points cannot be null or negative.");
        }
    }

    private void validateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
    }

    private void validateAddress(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null.");
        }
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

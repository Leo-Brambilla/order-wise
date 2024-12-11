package com.order_wise.clients.domain.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class Address {
    private Long id;
    private Long clientId;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String addressType;
    private String zipCode;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Address() {
        this.createdAt = LocalDateTime.now();
    }

    public Address(Long id, Long clientId, String street, String number, String complement, String neighborhood,
                   String city, String state, String addressType, String zipCode, LocalDateTime createdAt,
                   LocalDateTime updatedAt) {
        validateAddress(street, city, state, addressType);
        this.id = id;
        this.clientId = clientId;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.addressType = addressType;
        this.zipCode = zipCode;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.updatedAt = updatedAt;
    }

    public Address(String street, String number, String city, String state, String addressType) {
        validateAddress(street, city, state, addressType);
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
        this.addressType = addressType;
        this.createdAt = LocalDateTime.now();
    }

    public Address(String street, String number, String city, String state, String addressType, String zipCode, String complement, String neighborhood) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
        this.addressType = addressType;
        this.zipCode = zipCode;
        this.complement = complement;
        this.neighborhood = neighborhood;
    }

    public void update(String street, String number, String complement, String neighborhood,
                       String city, String state, String addressType, String zipCode) {
        validateAddress(street, city, state, addressType);
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.addressType = addressType;
        this.zipCode = zipCode;
        this.updatedAt = LocalDateTime.now();
    }

    private void validateAddress(String street, String city, String state, String addressType) {
        if (street == null || street.isBlank()) {
            throw new IllegalArgumentException("Street cannot be null or blank.");
        }
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("City cannot be null or blank.");
        }
        if (state == null || state.isBlank()) {
            throw new IllegalArgumentException("State cannot be null.");
        }
        if (addressType == null || addressType.isBlank()) {
            throw new IllegalArgumentException("Address type cannot be null or blank.");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

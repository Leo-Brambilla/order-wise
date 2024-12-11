package com.order_wise.clients.application.dto.addressDTO;

import java.util.Objects;

public class AddressResponseDTO {

    private final Long id;
    private final String street;
    private final String city;
    private final String state;
    private final String zipCode;
    private final String number;
    private final String complement;
    private final String neighborhood;
    private final String addressType;

    public AddressResponseDTO(Long id, String street, String city, String state, String zipCode,
                              String number, String complement, String neighborhood, String addressType) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.addressType = addressType;
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getAddressType() {
        return addressType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressResponseDTO that = (AddressResponseDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

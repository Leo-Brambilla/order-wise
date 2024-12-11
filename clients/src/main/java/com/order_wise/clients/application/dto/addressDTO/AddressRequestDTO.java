package com.order_wise.clients.application.dto.addressDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class AddressRequestDTO {

    @NotBlank(message = "Street is required")
    private String street;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "ZipCode is required")
    private String zipCode;

    private String number;

    private String complement;

    private String neighborhood;

    @Pattern(regexp = "^(billing|shipping|other)$", message = "Type must be one of: billing, shipping, other")
    private String AddressType;

    public AddressRequestDTO() {
    }

    public AddressRequestDTO(String street, String city, String state, String zipCode, String number, String complement, String neighborhood, String AddressType) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.AddressType = AddressType;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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

    public String getAddressType() {
        return AddressType;
    }

    public void setAddressType(String addressType) {
        this.AddressType = addressType;
    }
}

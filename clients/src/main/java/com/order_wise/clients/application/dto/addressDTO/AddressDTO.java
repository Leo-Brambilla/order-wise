package com.order_wise.clients.application.dto.addressDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class AddressDTO {

    @NotBlank(message = "Street cannot be blank")
    private String street;

    @NotBlank(message = "Number cannot be blank")
    private String number;

    @NotBlank(message = "City cannot be blank")
    private String city;

    @NotBlank(message = "State cannot be blank")
    private String state;

    @Pattern(regexp = "^(billing|shipping|other)$", message = "Address type must be one of: billing, shipping, other")
    private String addressType;

    @NotBlank(message = "Zip code cannot be blank")
    private String zipCode;

    private String complement;

    private String neighborhood;

    public AddressDTO() {
    }

    public AddressDTO(String street, String number, String city, String state, String addressType, String zipCode, String complement, String neighborhood) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
        this.addressType = addressType;
        this.zipCode = zipCode;
        this.complement = complement;
        this.neighborhood = neighborhood;
    }

    // Getters and Setters
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
}

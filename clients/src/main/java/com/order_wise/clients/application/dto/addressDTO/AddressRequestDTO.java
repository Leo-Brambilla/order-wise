package com.order_wise.clients.application.dto.addressDTO;

import jakarta.validation.constraints.NotBlank;

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
    private String type;

    public @NotBlank(message = "Street is required")
    String getStreet() {
        return street;
    }

    public void setStreet(@NotBlank(message = "Street is required") String street) {
        this.street = street;
    }

    public @NotBlank(message = "City is required") String getCity() {
        return city;
    }

    public void setCity(@NotBlank(message = "City is required") String city) {
        this.city = city;
    }

    public @NotBlank(message = "State is required") String getState() {
        return state;
    }

    public void setState(@NotBlank(message = "State is required") String state) {
        this.state = state;
    }

    public @NotBlank(message = "ZipCode is required") String getZipCode() {
        return zipCode;
    }

    public void setZipCode(@NotBlank(message = "ZipCode is required") String zipCode) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

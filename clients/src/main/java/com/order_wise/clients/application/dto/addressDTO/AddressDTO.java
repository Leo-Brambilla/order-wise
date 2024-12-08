package com.order_wise.clients.application.dto.addressDTO;

import jakarta.validation.constraints.NotBlank;

public class AddressDTO {

    @NotBlank(message = "Street cannot be blank")
    private String street;

    @NotBlank(message = "Number cannot be blank")
    private String number;

    @NotBlank(message = "City cannot be blank")
    private String city;

    @NotBlank(message = "State cannot be blank")
    private String state;

    @NotBlank(message = "Address type cannot be blank")
    private String addressType;

    public AddressDTO() {
    }

    public AddressDTO(String street, String number, String city, String state, String addressType) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
        this.addressType = addressType;
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
}

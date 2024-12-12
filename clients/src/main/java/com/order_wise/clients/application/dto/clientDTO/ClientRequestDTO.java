package com.order_wise.clients.application.dto.clientDTO;

import com.order_wise.clients.application.dto.addressDTO.AddressDTO;
import com.order_wise.clients.application.dto.userDTO.UserRequestDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class ClientRequestDTO {

    @NotNull(message = "User information cannot be null")
    @Valid
    private static UserRequestDTO user;

    @NotNull(message = "Address information cannot be null")
    @Valid
    private AddressDTO address;

    private Integer loyaltyPoints = 0;

    private Long preferredPaymentMethodId;

    public ClientRequestDTO() {
    }

    public ClientRequestDTO(UserRequestDTO user, AddressDTO address, Integer loyaltyPoints, Long preferredPaymentMethodId) {
        this.user = user;
        this.address = address;
        this.loyaltyPoints = loyaltyPoints != null ? loyaltyPoints : 0; // Default if null
        this.preferredPaymentMethodId = preferredPaymentMethodId;
    }

    public static UserRequestDTO getUser() {
        return user;
    }

    public void setUser(UserRequestDTO user) {
        this.user = user;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
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
}

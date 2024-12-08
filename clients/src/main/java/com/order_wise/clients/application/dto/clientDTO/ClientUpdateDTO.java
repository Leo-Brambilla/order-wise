package com.order_wise.clients.application.dto.clientDTO;

import com.order_wise.clients.application.dto.addressDTO.AddressDTO;
import com.order_wise.clients.application.dto.userDTO.UserUpdateDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ClientUpdateDTO {

    @Valid
    @NotNull(message = "User information cannot be null")
    private final UserUpdateDTO user;

    @Min(value = 0, message = "Loyalty points must be zero or greater")
    private final Integer loyaltyPoints;

    @Valid
    private final AddressDTO address;

    public ClientUpdateDTO(UserUpdateDTO user, Integer loyaltyPoints, AddressDTO address) {
        this.user = user;
        this.loyaltyPoints = loyaltyPoints != null ? loyaltyPoints : 0;
        this.address = address;
    }

    public UserUpdateDTO getUser() {
        return user;
    }

    public Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public AddressDTO getAddress() {
        return address;
    }
}

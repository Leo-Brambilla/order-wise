package com.order_wise.clients.application.dto.clientDTO;

import com.order_wise.clients.application.dto.addressDTO.AddressResponseDTO;
import com.order_wise.clients.application.dto.userDTO.UserResponseDTO;

public class ClientResponseDTO {

    private final Long id;
    private final UserResponseDTO user;
    private final Integer loyaltyPoints;
    private final AddressResponseDTO address;

    public ClientResponseDTO(Long id, UserResponseDTO user, Integer loyaltyPoints, AddressResponseDTO address) {
        this.id = id;
        this.user = user;
        this.loyaltyPoints = loyaltyPoints != null ? loyaltyPoints : 0;
        this.address = address;
    }



    public Long getId() {
        return id;
    }

    public UserResponseDTO getUser() {
        return user;
    }

    public Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public AddressResponseDTO getAddress() {
        return address;
    }
}

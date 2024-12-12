package com.order_wise.clients.infrastructure.mappers;

import com.order_wise.clients.application.dto.addressDTO.AddressDTO;
import com.order_wise.clients.application.dto.clientDTO.ClientResponseDTO;
import com.order_wise.clients.application.dto.userDTO.UserRequestDTO;
import com.order_wise.clients.application.dto.userDTO.UserResponseDTO;
import com.order_wise.clients.domain.entities.Client;
import com.order_wise.clients.domain.entities.User;

public class ClientMapper {

    public static ClientResponseDTO toResponseDTO(Client client) {
        UserResponseDTO userResponse = new UserResponseDTO(
                client.getUser().getId(),
                client.getUser().getName(),
                client.getUser().getDocument(),
                client.getUser().getEmail(),
                client.getUser().getIsActive()
        );

        AddressDTO addressResponse = new AddressDTO(
                client.getAddress().getStreet(),
                client.getAddress().getNumber(),
                client.getAddress().getCity(),
                client.getAddress().getState(),
                client.getAddress().getAddressType()
        );

        return new ClientResponseDTO(
                client.getId(),
                userResponse,
                client.getLoyaltyPoints(),
                addressResponse
        );
    }

    public static User toUser(UserRequestDTO userDTO) {

        return new User(
                userDTO.getName(),
                userDTO.getDocument(),
                userDTO.getEmail(),
                userDTO.getPassword()
        );
    }
}

package com.order_wise.clients.infrastructure.mappers;

import com.order_wise.clients.application.dto.clientDTO.ClientRequestDTO;
import com.order_wise.clients.application.dto.clientDTO.ClientResponseDTO;
import com.order_wise.clients.domain.entities.Client;
import com.order_wise.clients.domain.mappers.ClientMapper;
import com.order_wise.clients.domain.mappers.AddressMapper;
import com.order_wise.clients.domain.mappers.UserMapper;
import com.order_wise.clients.infrastructure.persistence.entities.ClientEntity;

public class ClientMapperImpl implements ClientMapper {

    private final AddressMapper addressMapper;
    private final UserMapper userMapper;

    public ClientMapperImpl(AddressMapper addressMapper, UserMapper userMapper) {
        this.addressMapper = addressMapper;
        this.userMapper = userMapper;
    }

    @Override
    public Client toDomain(ClientRequestDTO clientRequestDTO) {
        if (clientRequestDTO == null) return null;

        return new Client(
                null,
                clientRequestDTO.getLoyaltyPoints(),
                clientRequestDTO.getIsActive(),
                addressMapper.toDomain(clientRequestDTO.getAddress()),
                userMapper.toDomain(clientRequestDTO.getUser())
        );
    }

    @Override
    public ClientResponseDTO toResponseDTO(Client client) {
        if (client == null) return null;

        return new ClientResponseDTO(
                client.getId(),
                userMapper.toResponseDTO(client.getUser()),
                client.getLoyaltyPoints(),
                addressMapper.toResponseDTO(client.getAddress())
        );
    }

    @Override
    public Client toDomain(ClientEntity clientEntity) {
        if (clientEntity == null) return null;

        return new Client(
                clientEntity.getId(),
                clientEntity.getLoyaltyPoints(),
                clientEntity.getIsActive(),
                addressMapper.toDomain(clientEntity.getAddress()),
                userMapper.toDomain(clientEntity.getUser())
        );
    }

    @Override
    public ClientEntity toEntity(Client client) {
        if (client == null) return null;

        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setId(client.getId());
        clientEntity.setLoyaltyPoints(client.getLoyaltyPoints());
        clientEntity.setIsActive(client.isActive());
        clientEntity.setAddress(addressMapper.toEntity(client.getAddress()));
        clientEntity.setUser(userMapper.toEntity(client.getUser()));
        return clientEntity;
    }
}

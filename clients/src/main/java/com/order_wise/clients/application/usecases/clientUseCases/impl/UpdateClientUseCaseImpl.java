package com.order_wise.clients.application.usecases.clientUseCases.impl;

import com.order_wise.clients.application.dto.clientDTO.ClientResponseDTO;
import com.order_wise.clients.application.dto.clientDTO.ClientUpdateDTO;
import com.order_wise.clients.application.usecases.clientUseCases.UpdateClientUseCase;
import com.order_wise.clients.domain.entities.Address;
import com.order_wise.clients.domain.entities.Client;
import com.order_wise.clients.domain.exceptions.UserNotFoundException;
import com.order_wise.clients.domain.mappers.AddressMapper;
import com.order_wise.clients.domain.mappers.ClientMapper;
import com.order_wise.clients.domain.repositories.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class UpdateClientUseCaseImpl implements UpdateClientUseCase {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final AddressMapper addressMapper;

    public UpdateClientUseCaseImpl(ClientRepository clientRepository, ClientMapper clientMapper, AddressMapper addressMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
        this.addressMapper = addressMapper;
    }

    @Override
    public ClientResponseDTO execute(Long clientId, @Valid ClientUpdateDTO clientUpdateDTO) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new UserNotFoundException("Cliente não encontrado com ID: " + clientId));

        if (clientUpdateDTO.getUser() != null) {
            client.getUser().update(
                    clientUpdateDTO.getUser().getName(),
                    clientUpdateDTO.getUser().getEmail(),
                    client.getUser().getPassword()
            );
        }

        if (clientUpdateDTO.getLoyaltyPoints() != null) {
            client.setLoyaltyPoints(clientUpdateDTO.getLoyaltyPoints());
        }

        if (clientUpdateDTO.getAddress() != null) {
            Address updatedAddress = addressMapper.toDomain(clientUpdateDTO.getAddress());
            client.setAddress(updatedAddress);
        }

        Client updatedClient = clientRepository.save(client);

        return clientMapper.toResponseDTO(updatedClient);
    }
}

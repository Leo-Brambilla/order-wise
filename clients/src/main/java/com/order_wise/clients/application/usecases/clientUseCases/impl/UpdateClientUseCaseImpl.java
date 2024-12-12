package com.order_wise.clients.application.usecases.clientUseCases.impl;

import com.order_wise.clients.application.dto.clientDTO.ClientResponseDTO;
import com.order_wise.clients.application.dto.clientDTO.ClientUpdateDTO;
import com.order_wise.clients.application.usecases.clientUseCases.UpdateClientUseCase;
import com.order_wise.clients.domain.entities.Address;
import com.order_wise.clients.domain.entities.Client;
import com.order_wise.clients.domain.exceptions.UserNotFoundException;
import com.order_wise.clients.domain.repositories.ClientRepository;
import com.order_wise.clients.infrastructure.mappers.AddressMapper;
import com.order_wise.clients.infrastructure.mappers.ClientMapper;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class UpdateClientUseCaseImpl implements UpdateClientUseCase {

    private final ClientRepository clientRepository;

    public UpdateClientUseCaseImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
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
            Address updatedAddress = AddressMapper.toDomain(clientUpdateDTO.getAddress());
            client.setAddress(updatedAddress);
        }

        Client updatedClient = clientRepository.save(client);

        return ClientMapper.toResponseDTO(updatedClient);
    }
}

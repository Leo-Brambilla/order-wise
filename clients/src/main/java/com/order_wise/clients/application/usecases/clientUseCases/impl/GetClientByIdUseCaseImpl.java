package com.order_wise.clients.application.usecases.clientUseCases.impl;

import com.order_wise.clients.application.dto.clientDTO.ClientResponseDTO;
import com.order_wise.clients.application.usecases.clientUseCases.GetClientByIdUseCase;
import com.order_wise.clients.domain.entities.Client;
import com.order_wise.clients.domain.exceptions.UserNotFoundException;
import com.order_wise.clients.domain.repositories.ClientRepository;
import com.order_wise.clients.infrastructure.mappers.ClientMapper;
import org.springframework.stereotype.Service;

@Service
public class GetClientByIdUseCaseImpl implements GetClientByIdUseCase {

    private final ClientRepository clientRepository;

    public GetClientByIdUseCaseImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientResponseDTO execute(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new UserNotFoundException("Cliente não encontrado com ID: " + clientId));

        return ClientMapper.toResponseDTO(client);
    }
}

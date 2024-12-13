package com.order_wise.clients.application.usecases.clientUseCases.impl;

import com.order_wise.clients.application.dto.clientDTO.ClientResponseDTO;
import com.order_wise.clients.application.usecases.clientUseCases.GetClientByIdUseCase;
import com.order_wise.clients.domain.entities.Client;
import com.order_wise.clients.domain.exceptions.UserNotFoundException;
import com.order_wise.clients.domain.mappers.ClientMapper;
import com.order_wise.clients.domain.repositories.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class GetClientByIdUseCaseImpl implements GetClientByIdUseCase {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public GetClientByIdUseCaseImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public ClientResponseDTO execute(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new UserNotFoundException("Cliente não encontrado com ID: " + clientId));

        return clientMapper.toResponseDTO(client);
    }
}

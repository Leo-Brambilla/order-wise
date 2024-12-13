package com.order_wise.clients.application.usecases.clientUseCases.impl;

import com.order_wise.clients.application.dto.clientDTO.ClientRequestDTO;
import com.order_wise.clients.application.dto.clientDTO.ClientResponseDTO;
import com.order_wise.clients.application.usecases.clientUseCases.CreateClientUseCase;
import com.order_wise.clients.domain.entities.Client;
import com.order_wise.clients.domain.mappers.ClientMapper;
import com.order_wise.clients.domain.repositories.ClientRepository;
import com.order_wise.clients.domain.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class CreateClientUseCaseImpl implements CreateClientUseCase {

    private final ClientRepository clientRepository;
    private final UserRepository userRepository;
    private final ClientMapper clientMapper;

    public CreateClientUseCaseImpl(ClientRepository clientRepository, UserRepository userRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.userRepository = userRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public ClientResponseDTO execute(@Valid ClientRequestDTO clientRequestDTO) {
        Client newClient = clientMapper.toDomain(clientRequestDTO);
        Client savedClient = clientRepository.save(newClient);

        return clientMapper.toResponseDTO(savedClient);
    }
}

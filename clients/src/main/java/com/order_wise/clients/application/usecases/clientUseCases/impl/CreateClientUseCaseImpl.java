package com.order_wise.clients.application.usecases.clientUseCases.impl;

import com.order_wise.clients.application.dto.clientDTO.ClientRequestDTO;
import com.order_wise.clients.application.dto.clientDTO.ClientResponseDTO;
import com.order_wise.clients.application.usecases.clientUseCases.CreateClientUseCase;
import com.order_wise.clients.domain.entities.Address;
import com.order_wise.clients.domain.entities.Client;
import com.order_wise.clients.domain.entities.User;
import com.order_wise.clients.domain.repositories.ClientRepository;
import com.order_wise.clients.domain.repositories.UserRepository;
import com.order_wise.clients.infrastructure.mappers.AddressMapper;
import com.order_wise.clients.infrastructure.mappers.ClientMapper;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class CreateClientUseCaseImpl implements CreateClientUseCase {

    private final ClientRepository clientRepository;
    private final UserRepository userRepository;

    public CreateClientUseCaseImpl(ClientRepository clientRepository, UserRepository userRepository) {
        this.clientRepository = clientRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ClientResponseDTO execute(@Valid ClientRequestDTO clientRequestDTO) {
        User user = ClientMapper.toUser(clientRequestDTO.getUser());

        Address address = AddressMapper.toDomain(clientRequestDTO.getAddress());

        Client newClient = new Client(user, address);

        Client savedClient = clientRepository.save(newClient);

        return ClientMapper.toResponseDTO(savedClient);
    }
}

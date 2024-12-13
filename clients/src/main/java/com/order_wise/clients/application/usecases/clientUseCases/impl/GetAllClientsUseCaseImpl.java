package com.order_wise.clients.application.usecases.clientUseCases.impl;

import com.order_wise.clients.application.dto.clientDTO.ClientResponseDTO;
import com.order_wise.clients.application.usecases.clientUseCases.GetAllClientsUseCase;
import com.order_wise.clients.domain.entities.Client;
import com.order_wise.clients.domain.mappers.ClientMapper;
import com.order_wise.clients.domain.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllClientsUseCaseImpl implements GetAllClientsUseCase {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public GetAllClientsUseCaseImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public List<ClientResponseDTO> execute() {
        List<Client> clients = clientRepository.findAll();

        return clients.stream()
                .map(clientMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}

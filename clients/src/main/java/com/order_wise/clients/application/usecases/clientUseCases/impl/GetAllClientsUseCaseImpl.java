package com.order_wise.clients.application.usecases.clientUseCases.impl;

import com.order_wise.clients.application.dto.clientDTO.ClientResponseDTO;
import com.order_wise.clients.application.usecases.clientUseCases.GetAllClientsUseCase;
import com.order_wise.clients.domain.entities.Client;
import com.order_wise.clients.domain.repositories.ClientRepository;
import com.order_wise.clients.infrastructure.mappers.ClientMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllClientsUseCaseImpl implements GetAllClientsUseCase {

    private final ClientRepository clientRepository;

    public GetAllClientsUseCaseImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientResponseDTO> execute() {
        List<Client> clients = clientRepository.findAll();

        return clients.stream()
                .map(ClientMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}

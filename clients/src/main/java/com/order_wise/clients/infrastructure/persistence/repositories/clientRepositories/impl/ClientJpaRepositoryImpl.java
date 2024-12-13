package com.order_wise.clients.infrastructure.persistence.repositories.clientRepositories.impl;

import com.order_wise.clients.domain.entities.Client;
import com.order_wise.clients.domain.mappers.ClientMapper;
import com.order_wise.clients.domain.repositories.ClientRepository;
import com.order_wise.clients.infrastructure.persistence.repositories.clientRepositories.ClientJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ClientJpaRepositoryImpl implements ClientRepository {

    private final ClientJpaRepository clientJpaRepository;
    private final ClientMapper clientMapper;

    public ClientJpaRepositoryImpl(ClientJpaRepository clientJpaRepository, ClientMapper clientMapper) {
        this.clientJpaRepository = clientJpaRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public Client save(Client client) {
        return clientMapper.toDomain(clientJpaRepository.save(clientMapper.toEntity(client)));
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientJpaRepository.findById(id)
                .map(clientMapper::toDomain);
    }

    @Override
    public List<Client> findAll() {
        return clientJpaRepository.findAll()
                .stream()
                .map(clientMapper::toDomain)
                .collect(Collectors.toList());
    }
}

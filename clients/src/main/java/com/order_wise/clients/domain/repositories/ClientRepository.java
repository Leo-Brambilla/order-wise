package com.order_wise.clients.domain.repositories;

import com.order_wise.clients.domain.entities.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    Client save(Client client);
    Optional<Client> findById(Long id);
    List<Client> findAll();

}

package com.order_wise.clients.domain.repositories;

import com.order_wise.clients.domain.entities.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    Client save(Client client);

    Optional<Client> findById(Long id);

    Optional<Client> findByDocument(String document);

    void deleteById(Long id);

    List<Client> findAll();

    List<Client> findByPreferredPaymentMethodId(Long paymentMethodId);
}

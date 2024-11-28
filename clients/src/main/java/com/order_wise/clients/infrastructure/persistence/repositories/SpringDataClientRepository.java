package com.order_wise.clients.infrastructure.persistence.repositories;

import com.order_wise.clients.domain.entities.Client;
import com.order_wise.clients.domain.repositories.ClientRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpringDataClientRepository extends ClientRepository, JpaRepository<Client, Long> {

    @Override
    Optional<Client> findByDocument(String document);

    @Override
    List<Client> findByPreferredPaymentMethodId(Long paymentMethodId);
}

package com.order_wise.clients.infrastructure.persistence.repositories.clientRepositories;

import com.order_wise.clients.infrastructure.persistence.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientJpaRepository extends JpaRepository<ClientEntity, Long> {
}

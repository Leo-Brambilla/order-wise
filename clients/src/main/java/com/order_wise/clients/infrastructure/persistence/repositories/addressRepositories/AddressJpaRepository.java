package com.order_wise.clients.infrastructure.persistence.repositories.addressRepositories;

import com.order_wise.clients.infrastructure.persistence.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressJpaRepository extends JpaRepository<AddressEntity, Long> {
    List<AddressEntity> findByClientId(Long clientId);
}

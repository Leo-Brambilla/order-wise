package com.order_wise.clients.infrastructure.persistence.repositories;

import com.order_wise.clients.infrastructure.persistence.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataJpaAddressRepository extends JpaRepository<AddressEntity, Long> {
    List<AddressEntity> findByClientId(Long clientId);
}

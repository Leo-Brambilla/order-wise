package com.order_wise.clients.infrastructure.persistence.repositories;

import com.order_wise.clients.domain.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataJpaAddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByClientId(Long clientId);
}

package com.order_wise.clients.domain.repositories;

import com.order_wise.clients.domain.entities.Address;

import java.util.List;
import java.util.Optional;

public interface AddressRepository {

    Address save(Address address);

    Optional<Address> findById(Long id);

    List<Address> findByClientId(Long clientId);

    void deleteById(Long id);

    List<Address> findAll();
}

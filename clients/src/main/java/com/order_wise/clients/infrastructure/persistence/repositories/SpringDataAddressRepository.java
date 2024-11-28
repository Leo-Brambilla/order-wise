package com.order_wise.clients.infrastructure.persistence.repositories;

import com.order_wise.clients.domain.entities.Address;
import com.order_wise.clients.domain.repositories.AddressRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SpringDataAddressRepository implements AddressRepository {

    private final SpringDataJpaAddressRepository jpaRepository;

    public SpringDataAddressRepository(SpringDataJpaAddressRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Address save(Address address) {
        return jpaRepository.save(address);
    }

    @Override
    public Optional<Address> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<Address> findByClientId(Long clientId) {
        return jpaRepository.findByClientId(clientId);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<Address> findAll() {
        return jpaRepository.findAll();
    }
}

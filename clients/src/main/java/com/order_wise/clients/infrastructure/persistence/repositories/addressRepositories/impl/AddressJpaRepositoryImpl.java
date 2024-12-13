package com.order_wise.clients.infrastructure.persistence.repositories.addressRepositories.impl;

import com.order_wise.clients.domain.entities.Address;
import com.order_wise.clients.domain.repositories.AddressRepository;
import com.order_wise.clients.domain.mappers.AddressMapper;
import com.order_wise.clients.infrastructure.persistence.repositories.addressRepositories.AddressJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AddressJpaRepositoryImpl implements AddressRepository {

    private final AddressJpaRepository jpaRepository;
    private final AddressMapper addressMapper;

    public AddressJpaRepositoryImpl(AddressJpaRepository jpaRepository, AddressMapper addressMapper) {
        this.jpaRepository = jpaRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public Address save(Address address) {
        var entity = addressMapper.toEntity(address);
        var savedEntity = jpaRepository.save(entity);
        return addressMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Address> findById(Long id) {
        return jpaRepository.findById(id)
                .map(addressMapper::toDomain);
    }

    @Override
    public List<Address> findByClientId(Long clientId) {
        return jpaRepository.findByClientId(clientId)
                .stream()
                .map(addressMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<Address> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(addressMapper::toDomain)
                .collect(Collectors.toList());
    }
}

package com.order_wise.clients.infrastructure.persistence.repositories;

import com.order_wise.clients.domain.entities.Address;
import com.order_wise.clients.domain.repositories.AddressRepository;
import com.order_wise.clients.infrastructure.mappers.AddressMapper;
import com.order_wise.clients.infrastructure.persistence.entities.AddressEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SpringDataAddressRepository implements AddressRepository {

    private final SpringDataJpaAddressRepository jpaRepository;

    public SpringDataAddressRepository(SpringDataJpaAddressRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Address save(Address address) {
        AddressEntity entity = AddressMapper.toEntity(address);
        AddressEntity savedEntity = jpaRepository.save(entity);
        return AddressMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Address> findById(Long id) {
        return jpaRepository.findById(id)
                .map(AddressMapper::toDomain);
    }

    @Override
    public List<Address> findByClientId(Long clientId) {
        return jpaRepository.findByClientId(clientId)
                .stream()
                .map(AddressMapper::toDomain)
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
                .map(AddressMapper::toDomain)
                .collect(Collectors.toList());
    }
}

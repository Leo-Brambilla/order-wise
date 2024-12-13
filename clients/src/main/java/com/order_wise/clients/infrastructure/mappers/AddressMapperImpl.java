package com.order_wise.clients.infrastructure.mappers;

import com.order_wise.clients.application.dto.addressDTO.AddressDTO;
import com.order_wise.clients.application.dto.addressDTO.AddressRequestDTO;
import com.order_wise.clients.application.dto.addressDTO.AddressResponseDTO;
import com.order_wise.clients.domain.entities.Address;
import com.order_wise.clients.domain.mappers.AddressMapper;
import com.order_wise.clients.infrastructure.persistence.entities.AddressEntity;
import org.springframework.stereotype.Component;

@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public Address toDomain(AddressRequestDTO requestDTO) {
        if (requestDTO == null) return null;

        return new Address(
                null,
                null,
                requestDTO.getStreet(),
                requestDTO.getNumber(),
                requestDTO.getComplement(),
                requestDTO.getNeighborhood(),
                requestDTO.getCity(),
                requestDTO.getState(),
                requestDTO.getAddressType(),
                requestDTO.getZipCode(),
                null,
                null
        );
    }

    @Override
    public AddressEntity toEntity(Address domain) {
        if (domain == null) return null;

        return new AddressEntity(
                domain.getId(),
                domain.getClientId(),
                domain.getStreet(),
                domain.getNumber(),
                domain.getComplement(),
                domain.getNeighborhood(),
                domain.getCity(),
                domain.getState(),
                domain.getZipCode(),
                domain.getAddressType(),
                domain.getCreatedAt(),
                domain.getUpdatedAt()
        );
    }

    @Override
    public Address toDomain(AddressEntity entity) {
        if (entity == null) return null;

        return new Address(
                entity.getId(),
                entity.getClientId(),
                entity.getStreet(),
                entity.getNumber(),
                entity.getComplement(),
                entity.getNeighborhood(),
                entity.getCity(),
                entity.getState(),
                entity.getAddressType(),
                entity.getZipCode(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    @Override
    public AddressResponseDTO toResponseDTO(Address domain) {
        if (domain == null) return null;

        return new AddressResponseDTO(
                domain.getId(),
                domain.getStreet(),
                domain.getNumber(),
                domain.getCity(),
                domain.getState(),
                domain.getZipCode(),
                domain.getComplement(),
                domain.getNeighborhood(),
                domain.getAddressType()
        );
    }

    @Override
    public Address toDomain(AddressDTO addressDTO) {
        if (addressDTO == null) return null;

        return new Address(
                null,
                null,
                addressDTO.getStreet(),
                addressDTO.getNumber(),
                addressDTO.getComplement(),
                addressDTO.getNeighborhood(),
                addressDTO.getCity(),
                addressDTO.getState(),
                addressDTO.getZipCode(),
                addressDTO.getAddressType(),
                null,
                null
        );
    }
}

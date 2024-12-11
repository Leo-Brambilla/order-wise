package com.order_wise.clients.infrastructure.mappers;

import com.order_wise.clients.application.dto.addressDTO.AddressRequestDTO;
import com.order_wise.clients.application.dto.addressDTO.AddressResponseDTO;
import com.order_wise.clients.domain.entities.Address;
import com.order_wise.clients.infrastructure.persistence.entities.AddressEntity;

public class AddressMapper {


    public static AddressEntity toEntity(AddressRequestDTO dto) {
        if (dto == null) return null;

        return new AddressEntity(
                null,
                null,
                dto.getStreet(),
                dto.getNumber(),
                dto.getComplement(),
                dto.getNeighborhood(),
                dto.getCity(),
                dto.getState(),
                dto.getZipCode(),
                dto.getAddressType()
        );
    }

    public static AddressEntity toEntity(Address address) {
        if (address == null) return null;

        return new AddressEntity(
                address.getClientId(),
                address.getStreet(),
                address.getNumber(),
                address.getComplement(),
                address.getNeighborhood(),
                address.getCity(),
                address.getState(),
                address.getZipCode(),
                address.getAddressType()
        );
    }

    public static Address toDomain(AddressEntity entity) {
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

    public static AddressResponseDTO toResponseDTO(Address address) {
        if (address == null) return null;

        return new AddressResponseDTO(
                address.getId(),
                address.getStreet(),
                address.getNumber(),
                address.getCity(),
                address.getState(),
                address.getZipCode(),
                address.getComplement(),
                address.getNeighborhood(),
                address.getAddressType()
        );
    }
}

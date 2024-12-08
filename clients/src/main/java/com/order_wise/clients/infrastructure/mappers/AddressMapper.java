package com.order_wise.clients.infrastructure.mappers;

import com.order_wise.clients.application.dto.addressDTO.AddressRequestDTO;
import com.order_wise.clients.application.dto.addressDTO.AddressResponseDTO;
import com.order_wise.clients.domain.entities.Address;

public class AddressMapper {

    public static Address toEntity(AddressRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return new Address(
                dto.getStreet(),
                dto.getNumber(),
                dto.getCity(),
                dto.getState(),
                dto.getType(),
                dto.getZipCode(),
                dto.getComplement(),
                dto.getNeighborhood()
        );
    }

    public static AddressResponseDTO toResponseDTO(Address address) {
        if (address == null) {
            return null;
        }
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

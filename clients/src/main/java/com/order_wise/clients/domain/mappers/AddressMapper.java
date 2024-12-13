package com.order_wise.clients.domain.mappers;

import com.order_wise.clients.application.dto.addressDTO.AddressDTO;
import com.order_wise.clients.application.dto.addressDTO.AddressRequestDTO;
import com.order_wise.clients.application.dto.addressDTO.AddressResponseDTO;
import com.order_wise.clients.domain.entities.Address;
import com.order_wise.clients.infrastructure.persistence.entities.AddressEntity;

public interface AddressMapper {

    Address toDomain(AddressRequestDTO requestDTO);
    AddressEntity toEntity(Address domain);
    Address toDomain(AddressEntity entity);
    AddressResponseDTO toResponseDTO(Address domain);
    Address toDomain(AddressDTO addressDTO);
}

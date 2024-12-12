package com.order_wise.clients.application.usecases.addressUseCases.impl;

import com.order_wise.clients.application.dto.addressDTO.AddressRequestDTO;
import com.order_wise.clients.application.dto.addressDTO.AddressResponseDTO;
import com.order_wise.clients.application.usecases.addressUseCases.CreateAddressUseCase;
import com.order_wise.clients.domain.repositories.AddressRepository;
import com.order_wise.clients.infrastructure.mappers.AddressMapper;
import org.springframework.stereotype.Service;

@Service
public class CreateAddressUseCaseImpl implements CreateAddressUseCase {

    private final AddressRepository addressRepository;

    public CreateAddressUseCaseImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public AddressResponseDTO execute(AddressRequestDTO addressRequestDTO) {
        var addressEntity = AddressMapper.toEntity(addressRequestDTO);
        var savedAddressEntity = addressRepository.save(AddressMapper.toDomain(addressEntity));

        return AddressMapper.toResponseDTO(savedAddressEntity);
    }

}

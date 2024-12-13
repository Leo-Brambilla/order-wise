package com.order_wise.clients.application.usecases.addressUseCases.impl;

import com.order_wise.clients.application.dto.addressDTO.AddressRequestDTO;
import com.order_wise.clients.application.dto.addressDTO.AddressResponseDTO;
import com.order_wise.clients.application.usecases.addressUseCases.CreateAddressUseCase;
import com.order_wise.clients.domain.mappers.AddressMapper;
import com.order_wise.clients.domain.repositories.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateAddressUseCaseImpl implements CreateAddressUseCase {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public CreateAddressUseCaseImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public AddressResponseDTO execute(AddressRequestDTO addressRequestDTO) {
        var addressDomain = addressMapper.toDomain(addressRequestDTO);
        var savedAddress = addressRepository.save(addressDomain);

        return addressMapper.toResponseDTO(savedAddress);
    }
}

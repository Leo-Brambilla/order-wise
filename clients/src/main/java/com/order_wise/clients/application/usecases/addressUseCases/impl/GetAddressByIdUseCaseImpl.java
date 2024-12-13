package com.order_wise.clients.application.usecases.addressUseCases.impl;

import com.order_wise.clients.application.dto.addressDTO.AddressResponseDTO;
import com.order_wise.clients.application.usecases.addressUseCases.GetAddressByIdUseCase;
import com.order_wise.clients.domain.mappers.AddressMapper;
import com.order_wise.clients.domain.repositories.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class GetAddressByIdUseCaseImpl implements GetAddressByIdUseCase {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public GetAddressByIdUseCaseImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public AddressResponseDTO execute(Long id) {
        var address = addressRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Address not found for ID: " + id));

        return addressMapper.toResponseDTO(address);
    }
}

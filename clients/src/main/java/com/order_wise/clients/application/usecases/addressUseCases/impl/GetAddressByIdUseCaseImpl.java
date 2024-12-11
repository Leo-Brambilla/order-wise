package com.order_wise.clients.application.usecases.addressUseCases.impl;

import com.order_wise.clients.application.dto.addressDTO.AddressResponseDTO;
import com.order_wise.clients.application.usecases.addressUseCases.GetAddressByIdUseCase;
import com.order_wise.clients.domain.repositories.AddressRepository;
import com.order_wise.clients.infrastructure.mappers.AddressMapper;
import org.springframework.stereotype.Service;

@Service
public class GetAddressByIdUseCaseImpl implements GetAddressByIdUseCase {

    private final AddressRepository addressRepository;

    public GetAddressByIdUseCaseImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public AddressResponseDTO execute(Long id) {
        var address = addressRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Address not found for ID: " + id));

        return AddressMapper.toResponseDTO(address);
    }
}

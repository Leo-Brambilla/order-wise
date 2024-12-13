package com.order_wise.clients.application.usecases.addressUseCases.impl;

import com.order_wise.clients.application.dto.addressDTO.AddressResponseDTO;
import com.order_wise.clients.application.usecases.addressUseCases.GetAllAddressUseCase;
import com.order_wise.clients.domain.mappers.AddressMapper;
import com.order_wise.clients.domain.repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


public class GetAllAddressUseCaseImpl implements GetAllAddressUseCase {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public GetAllAddressUseCaseImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public List<AddressResponseDTO> execute() {
        var addresses = addressRepository.findAll();

        return addresses.stream()
                .map(addressMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}

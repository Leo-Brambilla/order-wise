package com.order_wise.clients.application.usecases.addressUseCases.impl;

import com.order_wise.clients.application.dto.addressDTO.AddressResponseDTO;
import com.order_wise.clients.application.usecases.addressUseCases.GetAllAddressUseCase;
import com.order_wise.clients.domain.repositories.AddressRepository;
import com.order_wise.clients.infrastructure.mappers.AddressMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllAddressUseCaseImpl implements GetAllAddressUseCase {

    private final AddressRepository addressRepository;

    public GetAllAddressUseCaseImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<AddressResponseDTO> execute() {
        var addresses = addressRepository.findAll();

        return addresses.stream()
                .map(AddressMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}

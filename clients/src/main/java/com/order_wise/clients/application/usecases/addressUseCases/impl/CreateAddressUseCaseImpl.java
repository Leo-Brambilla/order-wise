package com.order_wise.clients.application.usecases.addressUseCases.impl;

import com.order_wise.clients.application.dto.addressDTO.AddressRequestDTO;
import com.order_wise.clients.application.dto.addressDTO.AddressResponseDTO;
import com.order_wise.clients.application.usecases.addressUseCases.CreateAddressUseCase;
import com.order_wise.clients.domain.entities.Address;
import com.order_wise.clients.domain.repositories.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateAddressUseCaseImpl implements CreateAddressUseCase {

    private final AddressRepository addressRepository;

    public CreateAddressUseCaseImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public AddressResponseDTO execute(AddressRequestDTO addressRequestDTO) {
        Address address = new Address(
                null,
                addressRequestDTO.getClientId(),
                addressRequestDTO.getStreet(),
                addressRequestDTO.getNumber(),
                addressRequestDTO.getComplement(),
                addressRequestDTO.getNeighborhood(),
                addressRequestDTO.getCity(),
                addressRequestDTO.getState(),
                addressRequestDTO.getType(),
                addressRequestDTO.getZipCode(),
                null,
                null
        );

        Address savedAddress = addressRepository.save(address);

        return new AddressResponseDTO(
                savedAddress.getId(),
                savedAddress.getStreet(),
                savedAddress.getCity(),
                savedAddress.getState(),
                savedAddress.getZipCode(),
                savedAddress.getNumber(),
                savedAddress.getComplement(),
                savedAddress.getNeighborhood(),
                savedAddress.getType()
        );
    }
}

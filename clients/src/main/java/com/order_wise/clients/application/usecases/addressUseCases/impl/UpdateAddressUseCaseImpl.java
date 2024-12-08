package com.order_wise.clients.application.usecases.addressUseCases.impl;


import com.order_wise.clients.application.dto.addressDTO.AddressUpdateDTO;
import com.order_wise.clients.application.usecases.addressUseCases.UpdateAddressUseCase;
import com.order_wise.clients.domain.entities.Address;
import com.order_wise.clients.domain.repositories.AddressRepository;

import java.time.LocalDateTime;

public class UpdateAddressUseCaseImpl implements UpdateAddressUseCase {

    private final AddressRepository addressRepository;

    public UpdateAddressUseCaseImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address execute(Long id, AddressUpdateDTO addressUpdateDTO) {
        Address existingAddress = addressRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Address not found for ID: " + id));

        existingAddress.setStreet(addressUpdateDTO.getStreet());
        existingAddress.setNumber(addressUpdateDTO.getNumber());
        existingAddress.setComplement(addressUpdateDTO.getComplement());
        existingAddress.setNeighborhood(addressUpdateDTO.getNeighborhood());
        existingAddress.setCity(addressUpdateDTO.getCity());
        existingAddress.setState(addressUpdateDTO.getState());
        existingAddress.setZipCode(addressUpdateDTO.getZipCode());
        existingAddress.setAddressType(addressUpdateDTO.getType());
        existingAddress.setUpdatedAt(LocalDateTime.now());

        return addressRepository.save(existingAddress);
    }
}

package com.order_wise.clients.application.usecases.addressUseCases.impl;

import com.order_wise.clients.application.usecases.addressUseCases.GetAddressByIdUseCase;
import com.order_wise.clients.domain.entities.Address;
import com.order_wise.clients.domain.repositories.AddressRepository;


public class GetAddressByIdUseCaseImpl implements GetAddressByIdUseCase {

    private final AddressRepository addressRepository;

    public GetAddressByIdUseCaseImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address execute(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Address not found for ID: " + id));
    }
}

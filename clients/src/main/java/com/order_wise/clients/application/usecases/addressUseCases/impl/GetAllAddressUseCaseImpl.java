package com.order_wise.clients.application.usecases.addressUseCases.impl;

import com.order_wise.clients.application.usecases.addressUseCases.GetAllAddressUseCase;
import com.order_wise.clients.domain.entities.Address;
import com.order_wise.clients.domain.repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllAddressUseCaseImpl implements GetAllAddressUseCase {

    private final AddressRepository addressRepository;

    public GetAllAddressUseCaseImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> execute() {
        return addressRepository.findAll();
    }
}

package com.order_wise.clients.application.usecases.addressUseCases;

import com.order_wise.clients.application.dto.addressDTO.AddressRequestDTO;
import com.order_wise.clients.application.dto.addressDTO.AddressResponseDTO;

public interface CreateAddressUseCase {
    AddressResponseDTO execute(AddressRequestDTO addressRequestDTO);
}

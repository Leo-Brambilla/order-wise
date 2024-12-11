package com.order_wise.clients.application.usecases.addressUseCases;

import com.order_wise.clients.application.dto.addressDTO.AddressResponseDTO;
import com.order_wise.clients.application.dto.addressDTO.AddressUpdateDTO;

public interface UpdateAddressUseCase {
    AddressResponseDTO execute(Long id, AddressUpdateDTO addressUpdateDTO);
}

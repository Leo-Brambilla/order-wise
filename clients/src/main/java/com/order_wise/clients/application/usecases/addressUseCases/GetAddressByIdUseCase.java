package com.order_wise.clients.application.usecases.addressUseCases;

import com.order_wise.clients.application.dto.addressDTO.AddressResponseDTO;

public interface GetAddressByIdUseCase {
    AddressResponseDTO execute(Long id);
}

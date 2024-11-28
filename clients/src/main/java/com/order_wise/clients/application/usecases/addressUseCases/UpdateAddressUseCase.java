package com.order_wise.clients.application.usecases.addressUseCases;

import com.order_wise.clients.application.dto.addressDTO.AddressUpdateDTO;
import com.order_wise.clients.domain.entities.Address;


public interface UpdateAddressUseCase {
    Address execute(Long id, AddressUpdateDTO addressUpdateDTO);
}

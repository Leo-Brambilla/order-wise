package com.order_wise.clients.application.usecases.addressUseCases;

import com.order_wise.clients.domain.entities.Address;

public interface GetAddressByIdUseCase {
    Address execute(Long id);
}

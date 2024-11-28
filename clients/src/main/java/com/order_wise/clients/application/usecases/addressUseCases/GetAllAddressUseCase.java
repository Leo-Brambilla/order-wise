package com.order_wise.clients.application.usecases.addressUseCases;

import com.order_wise.clients.domain.entities.Address;
import java.util.List;

public interface GetAllAddressUseCase {
    List<Address> execute();
}

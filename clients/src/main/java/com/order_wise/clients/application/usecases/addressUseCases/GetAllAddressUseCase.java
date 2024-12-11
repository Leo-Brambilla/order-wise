package com.order_wise.clients.application.usecases.addressUseCases;

import com.order_wise.clients.application.dto.addressDTO.AddressResponseDTO;
import java.util.List;

public interface GetAllAddressUseCase {
    List<AddressResponseDTO> execute();
}

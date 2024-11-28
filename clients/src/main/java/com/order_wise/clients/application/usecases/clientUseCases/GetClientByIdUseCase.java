package com.order_wise.clients.application.usecases.clientUseCases;

import com.order_wise.clients.application.dto.clientDTO.ClientResponseDTO;

public interface GetClientByIdUseCase {
    ClientResponseDTO execute(Long clientId);
}

package com.order_wise.clients.application.usecases.clientUseCases;

import com.order_wise.clients.application.dto.ClientRequestDTO;
import com.order_wise.clients.application.dto.ClientResponseDTO;

public interface CreateClientUseCase {
    ClientResponseDTO execute(ClientRequestDTO clientRequestDTO);
}

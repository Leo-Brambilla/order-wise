package com.order_wise.clients.application.usecases.clientUseCases;

import com.order_wise.clients.application.dto.clientDTO.ClientRequestDTO;
import com.order_wise.clients.application.dto.clientDTO.ClientResponseDTO;

public interface CreateClientUseCase {
    ClientResponseDTO execute(ClientRequestDTO clientRequestDTO);
}

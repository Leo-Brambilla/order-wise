package com.order_wise.clients.application.usecases.clientUseCases;

import com.order_wise.clients.application.dto.clientDTO.ClientResponseDTO;
import com.order_wise.clients.application.dto.clientDTO.ClientUpdateDTO;

public interface UpdateClientUseCase {
    ClientResponseDTO execute(Long clientId, ClientUpdateDTO clientUpdateDTO);
}

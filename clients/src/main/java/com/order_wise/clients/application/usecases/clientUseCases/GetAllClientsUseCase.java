package com.order_wise.clients.application.usecases.clientUseCases;

import com.order_wise.clients.application.dto.clientDTO.ClientResponseDTO;

import java.util.List;

public interface GetAllClientsUseCase {
    List<ClientResponseDTO> execute();
}

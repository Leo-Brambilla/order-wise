package com.order_wise.clients.application.usecases.userUseCases;

import com.order_wise.clients.application.dto.userDTO.UserResponseDTO;

public interface GetUserByDocumentUseCase {
    UserResponseDTO execute(String document);
}

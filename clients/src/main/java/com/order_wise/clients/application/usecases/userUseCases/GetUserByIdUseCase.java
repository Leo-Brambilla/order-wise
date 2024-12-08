package com.order_wise.clients.application.usecases.userUseCases;

import com.order_wise.clients.application.dto.userDTO.UserResponseDTO;

public interface GetUserByIdUseCase {
    UserResponseDTO execute(Long userId);

}
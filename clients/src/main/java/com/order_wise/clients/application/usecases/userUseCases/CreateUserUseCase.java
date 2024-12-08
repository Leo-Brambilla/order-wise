package com.order_wise.clients.application.usecases.userUseCases;

import com.order_wise.clients.application.dto.userDTO.UserRequestDTO;
import com.order_wise.clients.application.dto.userDTO.UserResponseDTO;

public interface CreateUserUseCase {
    UserResponseDTO execute(UserRequestDTO userRequestDTO);
}

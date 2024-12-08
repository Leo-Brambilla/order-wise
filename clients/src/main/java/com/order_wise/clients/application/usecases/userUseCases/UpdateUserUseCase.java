package com.order_wise.clients.application.usecases.userUseCases;

import com.order_wise.clients.application.dto.userDTO.UserResponseDTO;
import com.order_wise.clients.application.dto.userDTO.UserUpdateDTO;

public interface UpdateUserUseCase {
    UserResponseDTO execute(Long userId, UserUpdateDTO userUpdateDTO);
}

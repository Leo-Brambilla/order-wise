package com.order_wise.clients.application.usecases.userUseCases;

import com.order_wise.clients.application.dto.userDTO.UserResponseDTO;

import java.util.List;

public interface GetAllUsersUseCase {
    List<UserResponseDTO> execute();
}

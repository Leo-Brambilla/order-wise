package com.order_wise.clients.application.usecases;

import com.order_wise.clients.application.dto.UserResponseDTO;
import com.order_wise.clients.domain.exceptions.UserNotFoundException;
import com.order_wise.clients.domain.repositories.UserRepository;
import com.order_wise.clients.domain.entities.User;

public class GetUserByIdUseCase {

    private final UserRepository userRepository;

    public GetUserByIdUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO execute(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));

        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getDocument(),
                user.getIsActive()
        );
    }
}

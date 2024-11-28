package com.order_wise.clients.application.usecases.userUseCases;

import com.order_wise.clients.application.dto.userDTO.UserRequestDTO;
import com.order_wise.clients.application.dto.userDTO.UserResponseDTO;
import com.order_wise.clients.domain.entities.User;
import com.order_wise.clients.domain.repositories.UserRepository;

public class CreateUserUseCase {

    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO execute(UserRequestDTO requestDTO) {
        User user = new User(requestDTO.getName(), requestDTO.getDocument(), requestDTO.getPassword());
        User savedUser = userRepository.save(user);

        return new UserResponseDTO(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getDocument(),
                savedUser.getIsActive()
        );
    }
}

package com.order_wise.clients.application.usecases.userUseCases.impl;

import com.order_wise.clients.application.dto.userDTO.UserResponseDTO;
import com.order_wise.clients.application.usecases.userUseCases.GetUserByIdUseCase;
import com.order_wise.clients.domain.entities.User;
import com.order_wise.clients.domain.exceptions.UserNotFoundException;
import com.order_wise.clients.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class GetUserByIdUseCaseImpl implements GetUserByIdUseCase {

    private final UserRepository userRepository;

    public GetUserByIdUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO execute(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado com ID: " + userId));

        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getDocument(),
                user.getEmail(),
                user.getIsActive()
        );
    }
}

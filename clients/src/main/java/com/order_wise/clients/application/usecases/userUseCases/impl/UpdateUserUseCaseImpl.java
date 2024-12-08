package com.order_wise.clients.application.usecases.userUseCases.impl;

import com.order_wise.clients.application.dto.userDTO.UserUpdateDTO;
import com.order_wise.clients.application.dto.userDTO.UserResponseDTO;
import com.order_wise.clients.application.usecases.userUseCases.UpdateUserUseCase;
import com.order_wise.clients.domain.entities.User;
import com.order_wise.clients.domain.exceptions.UserNotFoundException;
import com.order_wise.clients.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserUseCaseImpl implements UpdateUserUseCase {

    private final UserRepository userRepository;

    public UpdateUserUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO execute(Long userId, UserUpdateDTO userUpdateDTO) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado com ID: " + userId));

        user.update(userUpdateDTO.getName(), userUpdateDTO.getEmail(), userUpdateDTO.getPassword());

        User updatedUser = userRepository.save(user);

        return new UserResponseDTO(
                updatedUser.getId(),
                updatedUser.getName(),
                updatedUser.getDocument(),
                updatedUser.getEmail(),
                updatedUser.getIsActive()
        );
    }
}

package com.order_wise.clients.application.usecases.userUseCases.impl;

import com.order_wise.clients.application.dto.userDTO.UserRequestDTO;
import com.order_wise.clients.application.dto.userDTO.UserResponseDTO;
import com.order_wise.clients.application.usecases.userUseCases.CreateUserUseCase;
import com.order_wise.clients.domain.entities.User;
import com.order_wise.clients.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepository userRepository;

    public CreateUserUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO execute(UserRequestDTO userRequestDTO) {
        userRepository.findByDocument(userRequestDTO.getDocument())
                .ifPresent(user -> {
                    throw new IllegalArgumentException("O Usuário " + userRequestDTO.getDocument() +" já possui cadastro ativo");
                });

        userRepository.findByEmail(userRequestDTO.getEmail())
                .ifPresent(user -> {
                    throw new IllegalArgumentException("O e-mail " + userRequestDTO.getEmail() +" já possui cadastro ativo");
                });

        User newUser = new User(
                userRequestDTO.getName(),
                userRequestDTO.getDocument(),
                userRequestDTO.getEmail(),
                userRequestDTO.getPassword()
        );
        User savedUser = userRepository.save(newUser);

        return new UserResponseDTO(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getDocument(),
                savedUser.getEmail(),
                savedUser.getIsActive()
        );
    }
}

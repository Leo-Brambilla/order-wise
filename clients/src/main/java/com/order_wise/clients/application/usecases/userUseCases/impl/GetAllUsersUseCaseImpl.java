package com.order_wise.clients.application.usecases.userUseCases.impl;

import com.order_wise.clients.application.dto.userDTO.UserResponseDTO;
import com.order_wise.clients.application.usecases.userUseCases.GetAllUsersUseCase;
import com.order_wise.clients.domain.entities.User;
import com.order_wise.clients.domain.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class GetAllUsersUseCaseImpl implements GetAllUsersUseCase {

    private final UserRepository userRepository;

    public GetAllUsersUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponseDTO> execute() {

        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> new UserResponseDTO(
                        user.getId(),
                        user.getName(),
                        user.getDocument(),
                        user.getEmail(),
                        user.getIsActive()
                ))
                .collect(Collectors.toList());
    }
}

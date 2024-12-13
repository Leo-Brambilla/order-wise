package com.order_wise.clients.application.usecases.userUseCases.impl;

import com.order_wise.clients.application.dto.userDTO.UserResponseDTO;
import com.order_wise.clients.application.usecases.userUseCases.GetUserByIdUseCase;
import com.order_wise.clients.domain.mappers.UserMapper;
import com.order_wise.clients.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class GetUserByIdUseCaseImpl implements GetUserByIdUseCase {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public GetUserByIdUseCaseImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponseDTO execute(Long userId) {
        return userRepository.findById(userId)
                .map(userMapper::toResponseDTO)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com ID: " + userId));
    }
}

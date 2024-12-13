package com.order_wise.clients.application.usecases.userUseCases.impl;

import com.order_wise.clients.application.dto.userDTO.UserResponseDTO;
import com.order_wise.clients.application.usecases.userUseCases.GetUserByDocumentUseCase;
import com.order_wise.clients.domain.exceptions.UserNotFoundException;
import com.order_wise.clients.domain.mappers.UserMapper;
import com.order_wise.clients.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class GetUserByDocumentUseCaseImpl implements GetUserByDocumentUseCase {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public GetUserByDocumentUseCaseImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponseDTO execute(String document) {
        var user = userRepository.findByDocument(document)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado com o documento " + document));

        return userMapper.toResponseDTO(user);
    }
}

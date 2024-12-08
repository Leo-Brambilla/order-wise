package com.order_wise.clients.application.usecases.userUseCases.impl;


import com.order_wise.clients.application.dto.userDTO.UserResponseDTO;
import com.order_wise.clients.application.usecases.userUseCases.GetUserByDocumentUseCase;
import com.order_wise.clients.domain.entities.User;
import com.order_wise.clients.domain.exceptions.UserNotFoundException;
import com.order_wise.clients.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class GetUserByDocumentUseCaseImpl implements GetUserByDocumentUseCase {

    private final UserRepository userRepository;

    public GetUserByDocumentUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO execute(String document) {

        User user = userRepository.findByDocument(document)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado com o documento "+document));

        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getDocument(),
                user.getEmail(),
                user.getIsActive()
        );
    }


}

package com.order_wise.clients.application.usecases;

import com.order_wise.clients.application.dto.UserResponseDTO;
import com.order_wise.clients.domain.entities.User;
import com.order_wise.clients.domain.exceptions.UserNotFoundException;
import com.order_wise.clients.domain.repositories.UserRepository;

public class GetUserByDocumentUseCase {

    private final UserRepository userRepository;

    public GetUserByDocumentUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO execute(String document) {
        User user = userRepository.findByDocument(document)
                .orElseThrow(() -> new UserNotFoundException("User with document " + document + " not found"));

        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getDocument(),
                user.getIsActive()
        );
    }
}

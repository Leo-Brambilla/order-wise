package com.order_wise.clients.application.usecases;

import com.order_wise.clients.application.dto.UserResponseDTO;
import com.order_wise.clients.domain.entities.User;
import com.order_wise.clients.domain.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class GetAllUsersUseCase {

    private final UserRepository userRepository;

    public GetAllUsersUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponseDTO> execute() {

        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> new UserResponseDTO(
                        user.getId(),
                        user.getName(),
                        user.getDocument(),
                        user.getIsActive()
                ))
                .collect(Collectors.toList());
    }
}

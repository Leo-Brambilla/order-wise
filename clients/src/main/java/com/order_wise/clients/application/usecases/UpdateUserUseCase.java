package com.order_wise.clients.application.usecases;

import com.order_wise.clients.application.dto.UserUpdateDTO;
import com.order_wise.clients.application.dto.UserResponseDTO;
import com.order_wise.clients.domain.entities.User;
import com.order_wise.clients.domain.exceptions.UserNotFoundException;
import com.order_wise.clients.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserUseCase {

    private final UserRepository userRepository;

    public UpdateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO execute(Long id, UserUpdateDTO updateDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));

        user.update(updateDTO.getName(), updateDTO.getPassword());

        User updatedUser = userRepository.save(user);

        return new UserResponseDTO(
                updatedUser.getId(),
                updatedUser.getName(),
                updatedUser.getDocument(),
                updatedUser.getIsActive()
        );
    }
}

package com.order_wise.clients.infrastructure.controllers;

import com.order_wise.clients.application.dto.UserRequestDTO;
import com.order_wise.clients.application.dto.UserResponseDTO;
import com.order_wise.clients.application.dto.UserUpdateDTO;
import com.order_wise.clients.application.usecases.CreateUserUseCase;
import com.order_wise.clients.application.usecases.GetAllUsersUseCase;
import com.order_wise.clients.application.usecases.GetUserByIdUseCase;
import com.order_wise.clients.application.usecases.UpdateUserUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final GetAllUsersUseCase getAllUsersUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final UpdateUserUseCase updateUserUseCase;

    public UserController(
            CreateUserUseCase createUserUseCase,
            GetAllUsersUseCase getAllUsersUseCase,
            GetUserByIdUseCase getUserByIdUseCase,
            UpdateUserUseCase updateUserUseCase
    ) {
        this.createUserUseCase = createUserUseCase;
        this.getAllUsersUseCase = getAllUsersUseCase;
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.updateUserUseCase = updateUserUseCase;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDTO userRequestDTO) {
        UserResponseDTO response = createUserUseCase.execute(userRequestDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> response = getAllUsersUseCase.execute();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        UserResponseDTO response = getUserByIdUseCase.execute(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(
            @PathVariable Long id,
            @RequestBody @Valid UserUpdateDTO updateDTO
    ) {
        UserResponseDTO response = updateUserUseCase.execute(id, updateDTO);
        return ResponseEntity.ok(response);
    }
}

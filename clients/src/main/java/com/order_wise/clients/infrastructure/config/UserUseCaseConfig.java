package com.order_wise.clients.infrastructure.config;

import com.order_wise.clients.application.usecases.userUseCases.*;
import com.order_wise.clients.application.usecases.userUseCases.impl.*;
import com.order_wise.clients.domain.mappers.UserMapper;
import com.order_wise.clients.domain.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserUseCaseConfig {

    @Bean
    public CreateUserUseCase createUserUseCase(UserRepository userRepository, UserMapper userMapper) {
        return new CreateUserUseCaseImpl(userRepository, userMapper);
    }

    @Bean
    public UpdateUserUseCase updateUserUseCase(UserRepository userRepository, UserMapper userMapper) {
        return new UpdateUserUseCaseImpl(userRepository, userMapper);
    }

    @Bean
    public GetUserByIdUseCase getUserByIdUseCase(UserRepository userRepository, UserMapper userMapper) {
        return new GetUserByIdUseCaseImpl(userRepository, userMapper);
    }

    @Bean
    public GetUserByDocumentUseCase getUserByDocumentUseCase(UserRepository userRepository, UserMapper userMapper) {
        return new GetUserByDocumentUseCaseImpl(userRepository, userMapper);
    }

    @Bean
    public GetAllUsersUseCase getAllUsersUseCase(UserRepository userRepository, UserMapper userMapper) {
        return new GetAllUsersUseCaseImpl(userRepository, userMapper);
    }
}

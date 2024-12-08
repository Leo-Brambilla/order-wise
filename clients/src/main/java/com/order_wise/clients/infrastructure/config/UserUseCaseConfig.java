package com.order_wise.clients.infrastructure.config;

import com.order_wise.clients.application.usecases.userUseCases.*;
import com.order_wise.clients.application.usecases.userUseCases.impl.*;
import com.order_wise.clients.domain.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserUseCaseConfig {

    @Bean
    public CreateUserUseCase createUserUseCase(UserRepository userRepository) {
        return new CreateUserUseCaseImpl(userRepository);
    }

    @Bean
    public UpdateUserUseCase updateUserUseCase(UserRepository userRepository) {
        return new UpdateUserUseCaseImpl(userRepository);
    }

    @Bean
    public GetUserByIdUseCase getUserByIdUseCase(UserRepository userRepository) {
        return new GetUserByIdUseCaseImpl(userRepository);
    }

    @Bean
    public GetUserByDocumentUseCase getUserByDocumentUseCase(UserRepository userRepository) {
        return new GetUserByDocumentUseCaseImpl(userRepository);
    }

    @Bean
    public GetAllUsersUseCase getAllUsersUseCase(UserRepository userRepository) {
        return new GetAllUsersUseCaseImpl(userRepository);
    }
}

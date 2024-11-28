package com.order_wise.clients.infrastructure.config;

import com.order_wise.clients.application.usecases.userUseCases.CreateUserUseCase;
import com.order_wise.clients.application.usecases.userUseCases.GetAllUsersUseCase;
import com.order_wise.clients.application.usecases.userUseCases.GetUserByIdUseCase;
import com.order_wise.clients.application.usecases.userUseCases.UpdateUserUseCase;
import com.order_wise.clients.domain.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserUseCaseConfig {

    @Bean
    public CreateUserUseCase createUserUseCase(UserRepository userRepository) {
        return new CreateUserUseCase(userRepository);
    }

    @Bean
    public GetAllUsersUseCase getAllUsersUseCase(UserRepository userRepository) {
        return new GetAllUsersUseCase(userRepository);
    }

    @Bean
    public GetUserByIdUseCase getUserByIdUseCase(UserRepository userRepository) {
        return new GetUserByIdUseCase(userRepository);
    }

    @Bean
    public UpdateUserUseCase updateUserUseCase(UserRepository userRepository) {
        return new UpdateUserUseCase(userRepository);
    }
}
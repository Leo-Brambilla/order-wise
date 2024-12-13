package com.order_wise.clients.infrastructure.config;

import com.order_wise.clients.application.usecases.clientUseCases.*;
import com.order_wise.clients.application.usecases.clientUseCases.impl.*;
import com.order_wise.clients.domain.mappers.AddressMapper;
import com.order_wise.clients.domain.mappers.ClientMapper;
import com.order_wise.clients.domain.mappers.UserMapper;
import com.order_wise.clients.domain.repositories.ClientRepository;
import com.order_wise.clients.domain.repositories.UserRepository;
import com.order_wise.clients.infrastructure.mappers.ClientMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientUseCaseConfig {

    @Bean
    public ClientMapper clientMapper(AddressMapper addressMapper, UserMapper userMapper) {
        return new ClientMapperImpl(addressMapper, userMapper);
    }


    @Bean
    public CreateClientUseCase createClientUseCase(ClientRepository clientRepository, UserRepository userRepository, ClientMapper clientMapper) {
        return new CreateClientUseCaseImpl(clientRepository, userRepository, clientMapper);
    }

    @Bean
    public GetClientByIdUseCase getClientByIdUseCase(ClientRepository clientRepository, ClientMapper clientMapper) {
        return new GetClientByIdUseCaseImpl(clientRepository, clientMapper);
    }

    @Bean
    public UpdateClientUseCase updateClientUseCase(ClientRepository clientRepository, ClientMapper clientMapper, AddressMapper addressMapper) {
        return new UpdateClientUseCaseImpl(clientRepository, clientMapper, addressMapper);
    }

    @Bean
    public GetAllClientsUseCase getAllClientsUseCase(ClientRepository clientRepository, ClientMapper clientMapper) {
        return new GetAllClientsUseCaseImpl(clientRepository, clientMapper);
    }
}

package com.order_wise.clients.infrastructure.config;

import com.order_wise.clients.application.usecases.addressUseCases.GetAddressByIdUseCase;
import com.order_wise.clients.application.usecases.addressUseCases.GetAllAddressUseCase;
import com.order_wise.clients.application.usecases.addressUseCases.UpdateAddressUseCase;
import com.order_wise.clients.application.usecases.addressUseCases.impl.GetAddressByIdUseCaseImpl;
import com.order_wise.clients.application.usecases.addressUseCases.impl.UpdateAddressUseCaseImpl;
import com.order_wise.clients.domain.repositories.AddressRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressUseCaseConfig {

    @Bean
    public GetAddressByIdUseCase getAddressByIdUseCase(AddressRepository addressRepository) {
        return new GetAddressByIdUseCaseImpl(addressRepository);
    }

    @Bean
    public UpdateAddressUseCase updateAddressUseCase(AddressRepository addressRepository) {
        return new UpdateAddressUseCaseImpl(addressRepository);
    }

    @Bean
    public GetAllAddressUseCase getAllAddressUseCase(AddressRepository addressRepository) {
        return new GetAllAddressUseCase(addressRepository);
    }
}

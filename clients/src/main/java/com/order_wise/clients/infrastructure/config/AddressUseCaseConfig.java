package com.order_wise.clients.infrastructure.config;

import com.order_wise.clients.application.usecases.addressUseCases.CreateAddressUseCase;
import com.order_wise.clients.application.usecases.addressUseCases.GetAddressByIdUseCase;
import com.order_wise.clients.application.usecases.addressUseCases.GetAllAddressUseCase;
import com.order_wise.clients.application.usecases.addressUseCases.UpdateAddressUseCase;
import com.order_wise.clients.application.usecases.addressUseCases.impl.CreateAddressUseCaseImpl;
import com.order_wise.clients.application.usecases.addressUseCases.impl.GetAddressByIdUseCaseImpl;
import com.order_wise.clients.application.usecases.addressUseCases.impl.GetAllAddressUseCaseImpl;
import com.order_wise.clients.application.usecases.addressUseCases.impl.UpdateAddressUseCaseImpl;
import com.order_wise.clients.domain.mappers.AddressMapper;
import com.order_wise.clients.domain.repositories.AddressRepository;
import com.order_wise.clients.infrastructure.mappers.AddressMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressUseCaseConfig {

    @Bean
    public AddressMapper addressMapper() {
        return new AddressMapperImpl();
    }

    @Bean
    public CreateAddressUseCase createAddressUseCase(AddressRepository addressRepository, AddressMapper addressMapper) {
        return new CreateAddressUseCaseImpl(addressRepository, addressMapper);
    }

    @Bean
    public GetAddressByIdUseCase getAddressByIdUseCase(AddressRepository addressRepository, AddressMapper addressMapper) {
        return new GetAddressByIdUseCaseImpl(addressRepository, addressMapper);
    }

    @Bean
    public UpdateAddressUseCase updateAddressUseCase(AddressRepository addressRepository, AddressMapper addressMapper) {
        return new UpdateAddressUseCaseImpl(addressRepository, addressMapper);
    }

    @Bean
    public GetAllAddressUseCase getAllAddressUseCase(AddressRepository addressRepository, AddressMapper addressMapper) {
        return new GetAllAddressUseCaseImpl(addressRepository, addressMapper);
    }
}

package com.order_wise.clients.application.usecases.clientUseCases.impl;


import com.order_wise.clients.application.dto.clientDTO.ClientRequestDTO;
import com.order_wise.clients.application.dto.clientDTO.ClientResponseDTO;
import com.order_wise.clients.application.usecases.clientUseCases.CreateClientUseCase;
import com.order_wise.clients.domain.entities.Address;
import com.order_wise.clients.domain.entities.Client;
import com.order_wise.clients.domain.entities.User;
import com.order_wise.clients.domain.repositories.ClientRepository;
import com.order_wise.clients.domain.repositories.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateClientUseCaseImpl implements CreateClientUseCase {

    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;

    public CreateClientUseCaseImpl(ClientRepository clientRepository, AddressRepository addressRepository) {
        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public ClientResponseDTO execute(ClientRequestDTO clientRequestDTO) {
        User user = new User(clientRequestDTO.getUserName(), clientRequestDTO.getUserDocument(), clientRequestDTO.getUserPassword());
        Address address = new Address();
        address.setStreet(clientRequestDTO.getAddressStreet());
        address.setNumber(clientRequestDTO.getAddressNumber());
        address.setCity(clientRequestDTO.getAddressCity());
        address.setState(clientRequestDTO.getAddressState());

        Client client = new Client(null, clientRequestDTO.getLoyaltyPoints(), clientRequestDTO.getPreferredPaymentMethodId(), address, user);

        Client savedClient = clientRepository.save(client);

        return new ClientResponseDTO(
                savedClient.getId(),
                savedClient.getUser().getName(),
                savedClient.getUser().getDocument(),
                savedClient.getLoyaltyPoints(),
                savedClient.getPreferredPaymentMethodId(),
                savedClient.getAddress().getStreet(),
                savedClient.getAddress().getCity()
        );
    }
}

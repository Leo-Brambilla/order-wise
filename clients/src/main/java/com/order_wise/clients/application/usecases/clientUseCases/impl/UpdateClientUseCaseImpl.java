package com.order_wise.clients.application.usecases.clientUseCases.impl;



import com.order_wise.clients.application.dto.clientDTO.ClientResponseDTO;
import com.order_wise.clients.application.dto.clientDTO.ClientUpdateDTO;
import com.order_wise.clients.application.usecases.clientUseCases.UpdateClientUseCase;
import com.order_wise.clients.domain.entities.Address;
import com.order_wise.clients.domain.entities.Client;
import com.order_wise.clients.domain.repositories.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateClientUseCaseImpl implements UpdateClientUseCase {

    private final ClientRepository clientRepository;

    public UpdateClientUseCaseImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientResponseDTO execute(Long clientId, ClientUpdateDTO clientUpdateDTO) {

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado com ID: " + clientId));

        client.getUser().update(clientUpdateDTO.getName(), clientUpdateDTO.getDocument());
        client.setPreferredPaymentMethodId(clientUpdateDTO.getPreferredPaymentMethodId());

        Address address = client.getAddress();
        address.setStreet(clientUpdateDTO.getStreet());
        address.setCity(clientUpdateDTO.getCity());

        clientRepository.save(client);

        return new ClientResponseDTO(
                client.getId(),
                client.getUser().getName(),
                client.getUser().getDocument(),
                client.getLoyaltyPoints(),
                client.getPreferredPaymentMethodId(),
                address.getStreet(),
                address.getCity()
        );
    }
}

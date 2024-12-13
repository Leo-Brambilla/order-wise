package com.order_wise.clients.domain.mappers;

import com.order_wise.clients.application.dto.clientDTO.ClientRequestDTO;
import com.order_wise.clients.application.dto.clientDTO.ClientResponseDTO;
import com.order_wise.clients.domain.entities.Client;
import com.order_wise.clients.infrastructure.persistence.entities.ClientEntity;

public interface ClientMapper {

    Client toDomain(ClientRequestDTO clientRequestDTO);
    ClientResponseDTO toResponseDTO(Client client);
    Client toDomain(ClientEntity clientEntity);
    ClientEntity toEntity(Client client);
}

package com.order_wise.clients.infrastructure.controllers;




import com.order_wise.clients.application.dto.ClientRequestDTO;
import com.order_wise.clients.application.dto.clientDTO.ClientResponseDTO;
import com.order_wise.clients.application.usecases.clientUseCases.CreateClientUseCase;
import com.order_wise.clients.application.usecases.clientUseCases.GetAllClientsUseCase;
import com.order_wise.clients.application.usecases.clientUseCases.GetClientByIdUseCase;
import com.order_wise.clients.application.usecases.clientUseCases.UpdateClientUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@Validated
public class ClientController {

    private final CreateClientUseCase createClientUseCase;
    private final GetAllClientsUseCase getAllClientsUseCase;
    private final GetClientByIdUseCase getClientByIdUseCase;
    private final UpdateClientUseCase updateClientUseCase;

    public ClientController(
            CreateClientUseCase createClientUseCase,
            GetAllClientsUseCase getAllClientsUseCase,
            GetClientByIdUseCase getClientByIdUseCase,
            UpdateClientUseCase updateClientUseCase) {
        this.createClientUseCase = createClientUseCase;
        this.getAllClientsUseCase = getAllClientsUseCase;
        this.getClientByIdUseCase = getClientByIdUseCase;
        this.updateClientUseCase = updateClientUseCase;
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> createClient(@RequestBody @Valid ClientRequestDTO clientRequestDTO) {
        ClientResponseDTO response = createClientUseCase.execute(clientRequestDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> getAllClients() {
        List<ClientResponseDTO> response = getAllClientsUseCase.execute();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> getClientById(@PathVariable Long id) {
        ClientResponseDTO response = getClientByIdUseCase.execute(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> updateClient(
            @PathVariable Long id,
            @RequestBody @Valid ClientRequestDTO clientRequestDTO) {
        ClientResponseDTO response = updateClientUseCase.execute(id, clientRequestDTO);
        return ResponseEntity.ok(response);
    }
}

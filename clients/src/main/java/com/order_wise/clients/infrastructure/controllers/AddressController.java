package com.order_wise.clients.infrastructure.controllers;


import com.order_wise.clients.application.dto.addressDTO.AddressRequestDTO;
import com.order_wise.clients.application.dto.addressDTO.AddressResponseDTO;
import com.order_wise.clients.application.dto.addressDTO.AddressUpdateDTO;
import com.order_wise.clients.application.usecases.addressUseCases.CreateAddressUseCase;
import com.order_wise.clients.application.usecases.addressUseCases.GetAddressByIdUseCase;
import com.order_wise.clients.application.usecases.addressUseCases.GetAllAddressUseCase;
import com.order_wise.clients.application.usecases.addressUseCases.UpdateAddressUseCase;
import com.order_wise.clients.domain.entities.Address;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final CreateAddressUseCase createAddressUseCase;
    private final GetAllAddressUseCase getAllAddressesUseCase;
    private final GetAddressByIdUseCase getAddressByIdUseCase;
    private final UpdateAddressUseCase updateAddressUseCase;

    public AddressController(
            CreateAddressUseCase createAddressUseCase,
            GetAllAddressUseCase getAllAddressesUseCase,
            GetAddressByIdUseCase getAddressByIdUseCase,
            UpdateAddressUseCase updateAddressUseCase
    ) {
        this.createAddressUseCase = createAddressUseCase;
        this.getAllAddressesUseCase = getAllAddressesUseCase;
        this.getAddressByIdUseCase = getAddressByIdUseCase;
        this.updateAddressUseCase = updateAddressUseCase;
    }

    @PostMapping
    public ResponseEntity<AddressResponseDTO> createAddress(@RequestBody @Valid AddressRequestDTO addressRequestDTO) {
        AddressResponseDTO createdAddress = createAddressUseCase.execute(addressRequestDTO);
        return ResponseEntity.ok(createdAddress);
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> addresses = getAllAddressesUseCase.execute();
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        Address address = getAddressByIdUseCase.execute(id);
        return ResponseEntity.ok(address);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody @Valid AddressUpdateDTO addressUpdateDTO) {
        Address updatedAddress = updateAddressUseCase.execute(id, addressUpdateDTO);
        return ResponseEntity.ok(updatedAddress);
    }

}

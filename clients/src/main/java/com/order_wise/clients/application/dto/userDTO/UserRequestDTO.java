package com.order_wise.clients.application.dto.userDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequestDTO {

    @NotBlank(message = "Name cannot be blank")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "CPF or CNPJ cannot be blank")
    private String document;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must have at least 8 characters")
    private String password;

    public UserRequestDTO(String name, String document, String password) {
        this.name = name;
        this.document = document;
        this.password = password;
    }

    public @NotBlank(message = "Name cannot be blank") @Size(max = 100, message = "Name cannot exceed 100 characters") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name cannot be blank") @Size(max = 100, message = "Name cannot exceed 100 characters") String name) {
        this.name = name;
    }

    public @NotBlank(message = "CPF or CNPJ cannot be blank") String getDocument() {
        return document;
    }

    public void setDocument(@NotBlank(message = "CPF or CNPJ cannot be blank") String document) {
        this.document = document;
    }

    public @NotBlank(message = "Password cannot be blank") @Size(min = 8, message = "Password must have at least 8 characters") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password cannot be blank") @Size(min = 8, message = "Password must have at least 8 characters") String password) {
        this.password = password;
    }
}

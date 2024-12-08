package com.order_wise.clients.application.dto.userDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserRequestDTO {

    @NotBlank(message = "Name cannot be blank")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "CPF or CNPJ cannot be blank")
    @Pattern(
            regexp = "\\d{11}|\\d{14}",
            message = "Document must be a valid CPF (11 digits) or CNPJ (14 digits)"
    )
    private String document;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email must be a valid format")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must have at least 8 characters")
    private String password;

    public UserRequestDTO(String name, String document, String email, String password) {
        this.name = name;
        this.document = document;
        this.email = email;
        this.password = password;
    }

    public @NotBlank(message = "Name cannot be blank") @Size(max = 100, message = "Name cannot exceed 100 characters") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name cannot be blank") @Size(max = 100, message = "Name cannot exceed 100 characters") String name) {
        this.name = name;
    }

    public @NotBlank(message = "CPF or CNPJ cannot be blank") @Pattern(
            regexp = "\\d{11}|\\d{14}",
            message = "Document must be a valid CPF (11 digits) or CNPJ (14 digits)"
    ) String getDocument() {
        return document;
    }

    public void setDocument(@NotBlank(message = "CPF or CNPJ cannot be blank") @Pattern(
            regexp = "\\d{11}|\\d{14}",
            message = "Document must be a valid CPF (11 digits) or CNPJ (14 digits)"
    ) String document) {
        this.document = document;
    }

    public @NotBlank(message = "Email cannot be blank") @Email(message = "Email must be a valid format") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email cannot be blank") @Email(message = "Email must be a valid format") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Password cannot be blank") @Size(min = 8, message = "Password must have at least 8 characters") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password cannot be blank") @Size(min = 8, message = "Password must have at least 8 characters") String password) {
        this.password = password;
    }
}

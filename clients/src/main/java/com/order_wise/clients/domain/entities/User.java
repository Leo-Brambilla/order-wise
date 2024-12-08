package com.order_wise.clients.domain.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class User {

    private Long id;
    private String name;
    private String document;
    private String email;
    private String password;
    private Boolean isActive = true;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User(Long id, String name, String document, String email, String password, Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt) {
        validateDocument(document);
        validateEmail(email);
        this.id = id;
        this.name = name;
        this.document = document;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public User(String name, String document, String password) {
        this.name = name;
        this.document = document;
        this.password = password;
    }

    public User(String name, String document, String email, String password) {
        this.name = name;
        this.document = document;
        this.email = email;
        this.password = password;
    }

    public void inactivate() {
        this.isActive = false;
        this.updatedAt = LocalDateTime.now();
    }

    public void update(String name, String email, String password) {
        validateEmail(email);
        this.name = name;
        this.email = email;
        this.password = password;
        this.updatedAt = LocalDateTime.now();
    }

    public void updateDocument(String newDocument) {
        validateDocument(newDocument);
        this.document = newDocument;
        this.updatedAt = LocalDateTime.now();
    }

    private void validateDocument(String document) {
        if (!isValidDocument(document)) {
            throw new IllegalArgumentException("Documento inválido. Deve ser um CPF (11 dígitos) ou CNPJ (14 dígitos).");
        }
    }

    private void validateEmail(String email) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Email inválido.");
        }
    }

    private boolean isValidDocument(String document) {
        return document != null && document.matches("\\d{11}|\\d{14}");
    }

    private boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(document, user.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(document);
    }
}

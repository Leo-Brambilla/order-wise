package com.order_wise.clients.application.dto.userDTO;

public class UserResponseDTO {

    private Long id;
    private String name;
    private String document;
    private String email;
    private Boolean isActive;

    public UserResponseDTO(Long id, String name, String document, String email, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.email = email;
        this.isActive = isActive;
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

    public Boolean getActive() {
        return isActive;
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

    public void setActive(Boolean active) {
        isActive = active;
    }
}

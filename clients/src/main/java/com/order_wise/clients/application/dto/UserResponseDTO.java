package com.order_wise.clients.application.dto;

public class UserResponseDTO {

    private Long id;
    private String name;
    private String document;
    private Boolean isActive = true;

    public UserResponseDTO(Long id, String name, String document, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.document = document;
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

    public Boolean getActive() {
        return isActive;
    }
}

package com.order_wise.clients.domain.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class User {

    private Long id;
    private String name;
    private String document;
    private String password;
    private Boolean isActive = true;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User(Long id, String name, String document, String password, Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.password = password;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public User(String name, String document, String password) {
        this.name = name;
        this.document = document;
        this.password = password;
        this.createdAt = LocalDateTime.now();
        this.isActive = true;
    }

    public void inactivate() {
        this.isActive = false;
        this.updatedAt = LocalDateTime.now();
    }

    public void update(String name, String password) {
        this.name = name;
        this.password = password;
        this.updatedAt = LocalDateTime.now();
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

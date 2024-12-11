package com.order_wise.clients.infrastructure.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_id", nullable = false)
    private Long clientId;

    @NotBlank(message = "Street cannot be blank")
    @Size(max = 255, message = "Street length cannot exceed 255 characters")
    @Column(name = "street", nullable = false, length = 255)
    private String street;

    @NotBlank(message = "Number cannot be blank")
    @Size(max = 50, message = "Number length cannot exceed 50 characters")
    @Column(name = "number", nullable = false, length = 50)
    private String number;

    @Size(max = 255, message = "Complement length cannot exceed 255 characters")
    @Column(name = "complement")
    private String complement;

    @NotBlank(message = "Neighborhood cannot be blank")
    @Size(max = 100, message = "Neighborhood length cannot exceed 100 characters")
    @Column(name = "neighborhood", nullable = false, length = 100)
    private String neighborhood;

    @NotBlank(message = "City cannot be blank")
    @Size(max = 100, message = "City length cannot exceed 100 characters")
    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @NotBlank(message = "State cannot be blank")
    @Size(max = 2, message = "State length must be 2 characters")
    @Column(name = "state", nullable = false, length = 2)
    private String state;

    @NotBlank(message = "Zip Code cannot be blank")
    @Size(max = 20, message = "Zip Code length cannot exceed 20 characters")
    @Column(name = "zip_code", nullable = false, length = 20)
    private String zipCode;

    @NotBlank(message = "Address Type cannot be blank")
    @Size(max = 50, message = "Address Type length cannot exceed 50 characters")
    @Column(name = "type", nullable = false, length = 50)
    private String addressType;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public AddressEntity() {
        this.createdAt = LocalDateTime.now();
    }

    public AddressEntity(Long clientId, String street, String number, String complement, String neighborhood,
                         String city, String state, String zipCode, String addressType) {
        this.clientId = clientId;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.addressType = addressType;
        this.createdAt = LocalDateTime.now();
    }

    public AddressEntity(Long id, Long clientId, String street, String number, String complement,
                         String neighborhood, String city, String state, String zipCode, String addressType) {
        this.id = id; // ID opcional, pode ser nulo para criação
        this.clientId = clientId; // Pode ser configurado após o mapeamento
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.addressType = addressType;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = null; // Inicialmente nulo
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}

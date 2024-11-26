package com.order_wise.clients.domain.entities;

import org.junit.Test;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.*;


public class UserTest {

    @Test
    void shouldCreateUserWithDefaultValues() {
        User user = new User("João da Silva", "12345678901", "senha123");

        assertNotNull(user.getId());
        assertEquals("João da Silva", user.getName());
        assertEquals("12345678901", user.getDocument());
        assertEquals("senha123", user.getPassword());
        assertTrue(user.getIsActive());
        assertNotNull(user.getCreatedAt());
        assertNull(user.getUpdatedAt());
    }

    @Test
    void shouldInactivateUser() {
        User user = new User("João da Silva", "12345678901", "senha123");
        user.inactivate();

        assertFalse(user.getIsActive());
        assertNotNull(user.getUpdatedAt());
    }

    @Test
    void shouldUpdateUserDetails() {
        User user = new User("João da Silva", "12345678901", "senha123");
        user.update("João Atualizado", "novaSenha123");

        assertEquals("João Atualizado", user.getName());
        assertEquals("novaSenha123", user.getPassword());
        assertNotNull(user.getUpdatedAt());
    }
}

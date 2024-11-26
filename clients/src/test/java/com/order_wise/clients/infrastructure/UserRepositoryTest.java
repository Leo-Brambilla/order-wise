package com.order_wise.clients.infrastructure;

import com.order_wise.clients.domain.entities.User;
import com.order_wise.clients.domain.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldSaveUser() {
        User user = new User("João da Silva", "12345678901", "senha123");
        User savedUser = userRepository.save(user);

        assertNotNull(savedUser.getId());
        assertEquals("João da Silva", savedUser.getName());
    }

    @Test
    void shouldFindUserById() {
        User user = new User("João da Silva", "12345678901", "senha123");
        User savedUser = userRepository.save(user);

        Optional<User> foundUser = userRepository.findById(savedUser.getId());
        assertTrue(foundUser.isPresent());
        assertEquals("João da Silva", foundUser.get().getName());
    }
}

package com.order_wise.clients.application;

import com.order_wise.clients.domain.entities.User;
import com.order_wise.clients.domain.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;



    @Test
    void shouldCreateUser() throws Exception {
        String userJson = """
            {
                "name": "João da Silva",
                "document": "12345678901",
                "password": "senha123"
            }
            """;

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.name").value("João da Silva"));
    }

    @Test
    void shouldGetUserById() throws Exception {
        User user = userRepository.save(new User("João da Silva", "12345678901", "senha123"));

        mockMvc.perform(get("/users/" + user.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("João da Silva"));
    }

    @Test
    void shouldReturn404WhenUserNotFound() throws Exception {
        mockMvc.perform(get("/users/999"))
                .andExpect(status().isNotFound());
    }
}

package com.order_wise.clients.domain.repositories;

import com.order_wise.clients.domain.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByDocument(String document);
    List<User> findAll();
    User save(User user);
    Optional<User> findById(Long id);
}

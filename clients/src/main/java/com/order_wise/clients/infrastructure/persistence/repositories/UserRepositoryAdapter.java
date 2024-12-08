package com.order_wise.clients.infrastructure.persistence.repositories;

import com.order_wise.clients.domain.entities.User;
import com.order_wise.clients.domain.repositories.UserRepository;
import com.order_wise.clients.infrastructure.mappers.UserMapper;
import com.order_wise.clients.infrastructure.persistence.entities.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryAdapter implements UserRepository {

    private final SpringDataUserRepository springDataUserRepository;

    public UserRepositoryAdapter(SpringDataUserRepository springDataUserRepository) {
        this.springDataUserRepository = springDataUserRepository;
    }

    @Override
    public Optional<User> findById(Long id) {
        return springDataUserRepository.findById(id)
                .map(UserMapper::toDomain);
    }

    @Override
    public Optional<User> findByDocument(String document) {
        return springDataUserRepository.findByDocument(document)
                .map(UserMapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return springDataUserRepository.findByEmail(email)
                .map(UserMapper::toDomain);
    }

    @Override
    public List<User> findAll() {
        return springDataUserRepository.findAll().stream()
                .map(UserMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public User save(User user) {
        UserEntity entity = UserMapper.toEntity(user);
        UserEntity savedEntity = springDataUserRepository.save(entity);
        return UserMapper.toDomain(savedEntity);
    }
}

package com.order_wise.clients.infrastructure.persistence.repositories;

import com.order_wise.clients.infrastructure.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByDocument(String document);
}

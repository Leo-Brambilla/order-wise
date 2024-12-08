package com.order_wise.clients.infrastructure.mappers;

import com.order_wise.clients.domain.entities.User;
import com.order_wise.clients.infrastructure.persistence.entities.UserEntity;

public class UserMapper {

    public static UserEntity toEntity(User user) {
        if (user == null) return null;

        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setDocument(user.getDocument());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setIsActive(user.getIsActive());
        entity.setCreatedAt(user.getCreatedAt());
        entity.setUpdatedAt(user.getUpdatedAt());
        return entity;
    }

    public static User toDomain(UserEntity entity) {
        if (entity == null) return null;

        return new User(
                entity.getId(),
                entity.getName(),
                entity.getDocument(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getIsActive(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}

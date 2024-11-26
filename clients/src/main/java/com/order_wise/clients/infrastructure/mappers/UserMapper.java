package com.order_wise.clients.infrastructure.mappers;

import com.order_wise.clients.domain.entities.User;
import com.order_wise.clients.infrastructure.persistence.UserEntity;



public class UserMapper {

    public static UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setDocument(user.getDocument());
        entity.setPassword(user.getPassword());
        entity.setIsActive(user.getIsActive());
        entity.setCreatedAt(user.getCreatedAt());
        entity.setUpdatedAt(user.getUpdatedAt());
        return entity;
    }

    public static User toDomain(UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getName(),
                entity.getDocument(),
                entity.getPassword(),
                entity.getIsActive(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}

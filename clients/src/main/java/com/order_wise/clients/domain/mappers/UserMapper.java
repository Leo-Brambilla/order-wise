package com.order_wise.clients.domain.mappers;

import com.order_wise.clients.application.dto.userDTO.UserRequestDTO;
import com.order_wise.clients.application.dto.userDTO.UserResponseDTO;
import com.order_wise.clients.domain.entities.User;
import com.order_wise.clients.infrastructure.persistence.entities.UserEntity;

public interface UserMapper {
    User toDomain(UserEntity entity);

    UserEntity toEntity(User user);

    User toDomain(UserRequestDTO userRequestDTO);

    UserResponseDTO toResponseDTO(User user);

}

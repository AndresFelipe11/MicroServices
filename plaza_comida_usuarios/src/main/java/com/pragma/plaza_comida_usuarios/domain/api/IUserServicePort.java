package com.pragma.plaza_comida_usuarios.domain.api;

import com.pragma.plaza_comida_usuarios.application.dto.response.AuthenticationResponseDto;
import com.pragma.plaza_comida_usuarios.domain.model.UserModel;
import com.pragma.plaza_comida_usuarios.infrastructure.out.jpa.entity.UserEntity;

import java.util.Optional;

public interface IUserServicePort {
    UserModel saveUser(UserModel userModel);

    Optional<UserEntity> findUserByEmail(String email);

    UserModel findUserByEmailModel(String email);

    UserModel getById(Long userId);
}

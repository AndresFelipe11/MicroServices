package com.pragma.plaza_comida_usuarios.domain.spi;

import com.pragma.plaza_comida_usuarios.domain.model.UserModel;
import com.pragma.plaza_comida_usuarios.infrastructure.out.jpa.entity.UserEntity;

import java.util.Optional;

public interface IUserPersistencePort {
    UserModel saveUser(UserModel userModel);
    Optional<UserEntity> findUserByEmail(String email);
    UserModel findUserByEmailModel(String email);
    UserModel getById(Long userId);
}

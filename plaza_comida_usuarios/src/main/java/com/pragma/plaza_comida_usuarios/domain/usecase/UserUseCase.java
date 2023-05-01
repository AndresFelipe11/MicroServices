package com.pragma.plaza_comida_usuarios.domain.usecase;

import com.pragma.plaza_comida_usuarios.application.dto.response.AuthenticationResponseDto;
import com.pragma.plaza_comida_usuarios.domain.api.IUserServicePort;
import com.pragma.plaza_comida_usuarios.domain.model.UserModel;
import com.pragma.plaza_comida_usuarios.domain.spi.IUserPersistencePort;
import com.pragma.plaza_comida_usuarios.infrastructure.out.jpa.entity.UserEntity;

import java.util.Optional;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }


    @Override
    public UserModel saveUser(UserModel userModel) {
        return userPersistencePort.saveUser(userModel);
    }

    @Override
    public Optional<UserEntity> findUserByEmail(String email) {
        return userPersistencePort.findUserByEmail(email);
    }

    @Override
    public UserModel findUserByEmailModel(String email) {
        return userPersistencePort.findUserByEmailModel(email);
    }

    @Override
    public UserModel getById(Long userId) {
        return userPersistencePort.getById(userId);
    }
}
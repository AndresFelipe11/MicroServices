package com.pragma.plaza_comida_usuarios.domain.usecase;

import com.pragma.plaza_comida_usuarios.domain.api.IUserServicePort;
import com.pragma.plaza_comida_usuarios.domain.model.UserModel;
import com.pragma.plaza_comida_usuarios.domain.spi.IUserPersistencePort;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }


    @Override
    public UserModel saveUser(UserModel userModel) {
        userPersistencePort.saveUser(userModel);
        return userModel;
    }
}
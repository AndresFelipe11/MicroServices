package com.pragma.plaza_comida_usuarios.domain.spi;

import com.pragma.plaza_comida_usuarios.domain.model.UserModel;

public interface IUserPersistencePort {
    UserModel saveUser(UserModel userModel);
}

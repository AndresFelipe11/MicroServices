package com.pragma.plaza_comida_usuarios.domain.api;

import com.pragma.plaza_comida_usuarios.domain.model.UserModel;

public interface IUserServicePort {
    UserModel saveUser(UserModel userModel);
}

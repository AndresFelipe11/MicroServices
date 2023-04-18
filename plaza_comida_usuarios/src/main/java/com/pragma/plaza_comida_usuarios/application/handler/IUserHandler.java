package com.pragma.plaza_comida_usuarios.application.handler;

import com.pragma.plaza_comida_usuarios.application.dto.request.UserRequestDto;

public interface IUserHandler {

    void saveUser(UserRequestDto userRequestDto);
}
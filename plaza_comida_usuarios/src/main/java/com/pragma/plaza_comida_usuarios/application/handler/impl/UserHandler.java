package com.pragma.plaza_comida_usuarios.application.handler.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.pragma.plaza_comida_usuarios.application.dto.request.UserRequestDto;
import com.pragma.plaza_comida_usuarios.application.handler.IUserHandler;
import com.pragma.plaza_comida_usuarios.application.mapper.request.IUserRequestMapper;
import com.pragma.plaza_comida_usuarios.domain.api.IUserServicePort;
import com.pragma.plaza_comida_usuarios.domain.model.RolModel;
import com.pragma.plaza_comida_usuarios.domain.model.UserModel;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserHandler implements IUserHandler {

    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;


    @Override
    public void saveUser(UserRequestDto userRequestDto) {
        RolModel rolModel = new RolModel();
        rolModel.setId(userRequestDto.getRolId());

        UserModel userModel = userRequestMapper.toUser(userRequestDto);
        userModel.setRolId(rolModel);

        userServicePort.saveUser(userModel);
    }
}

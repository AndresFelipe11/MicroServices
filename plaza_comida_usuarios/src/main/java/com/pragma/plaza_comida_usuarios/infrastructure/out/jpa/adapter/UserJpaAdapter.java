package com.pragma.plaza_comida_usuarios.infrastructure.out.jpa.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pragma.plaza_comida_usuarios.domain.model.UserModel;
import com.pragma.plaza_comida_usuarios.domain.spi.IUserPersistencePort;
import com.pragma.plaza_comida_usuarios.infrastructure.out.jpa.mapper.IUserEntityMapper;
import com.pragma.plaza_comida_usuarios.infrastructure.out.jpa.repository.IUserRepository;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserModel saveUser(UserModel userModel) {

        UserModel user = userModel;
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));

        userRepository.save(userEntityMapper.toEntity(user));
        return user;
    }

}

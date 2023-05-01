package com.pragma.plaza_comida_usuarios.infrastructure.out.jpa.adapter;

import com.pragma.plaza_comida_usuarios.domain.model.RolModel;
import com.pragma.plaza_comida_usuarios.domain.spi.IRolPersistencePort;
import com.pragma.plaza_comida_usuarios.infrastructure.out.jpa.mapper.IRolEntityMapper;
import com.pragma.plaza_comida_usuarios.infrastructure.out.jpa.repository.IRolRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RolJpaAdapter implements IRolPersistencePort {
    private final IRolRepository rolRepository;
    private final IRolEntityMapper rolEntityMapper;

    @Override
    public RolModel getRol(Long rolId) {
        return rolEntityMapper.toRolModel(rolRepository.findById(rolId).orElseThrow());
    }
}
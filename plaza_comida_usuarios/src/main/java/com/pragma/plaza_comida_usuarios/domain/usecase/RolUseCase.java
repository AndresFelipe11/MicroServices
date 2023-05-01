package com.pragma.plaza_comida_usuarios.domain.usecase;

import com.pragma.plaza_comida_usuarios.domain.api.IRolServicePort;
import com.pragma.plaza_comida_usuarios.domain.model.RolModel;
import com.pragma.plaza_comida_usuarios.domain.spi.IRolPersistencePort;

public class RolUseCase implements IRolServicePort {
    private final IRolPersistencePort rolPersistencePort;
    public RolUseCase(IRolPersistencePort rolPersistencePort){ this.rolPersistencePort = rolPersistencePort;}

    @Override
    public RolModel getRol(Long rolId) {
        return rolPersistencePort.getRol(rolId);
    }
}

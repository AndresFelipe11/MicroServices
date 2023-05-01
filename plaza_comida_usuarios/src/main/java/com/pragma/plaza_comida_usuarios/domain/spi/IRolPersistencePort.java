package com.pragma.plaza_comida_usuarios.domain.spi;

import com.pragma.plaza_comida_usuarios.domain.model.RolModel;

public interface IRolPersistencePort {
    RolModel getRol(Long rolId);
}

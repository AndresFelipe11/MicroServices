package com.pragma.plaza_comida_usuarios.domain.api;

import com.pragma.plaza_comida_usuarios.domain.model.RolModel;

public interface  IRolServicePort {
    RolModel getRol(Long rolId);
}

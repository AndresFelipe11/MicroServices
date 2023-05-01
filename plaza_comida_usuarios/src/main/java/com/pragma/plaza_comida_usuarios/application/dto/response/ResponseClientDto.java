package com.pragma.plaza_comida_usuarios.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseClientDto {
    private boolean error;
    private String message;
    private UserResponseDto data;
}
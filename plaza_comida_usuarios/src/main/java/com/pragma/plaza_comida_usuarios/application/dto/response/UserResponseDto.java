package com.pragma.plaza_comida_usuarios.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private String name;
    private String lastName;
    private String idNumber;
    private String phone;
    private String email;
    private String password;
    private RolResponseDto rolId;
}
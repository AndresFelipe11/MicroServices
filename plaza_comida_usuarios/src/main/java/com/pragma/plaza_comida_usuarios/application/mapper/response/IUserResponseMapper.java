package com.pragma.plaza_comida_usuarios.application.mapper.response;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.pragma.plaza_comida_usuarios.application.dto.response.UserResponseDto;
import com.pragma.plaza_comida_usuarios.domain.model.UserModel;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserResponseMapper {
    UserResponseDto toResponse(UserModel userModel);
}

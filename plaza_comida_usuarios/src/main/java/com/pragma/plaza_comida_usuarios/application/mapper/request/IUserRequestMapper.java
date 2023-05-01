package com.pragma.plaza_comida_usuarios.application.mapper.request;

import com.pragma.plaza_comida_usuarios.application.dto.request.RegisterRequestDto;
import com.pragma.plaza_comida_usuarios.application.dto.response.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.pragma.plaza_comida_usuarios.application.dto.request.UserRequestDto;
import com.pragma.plaza_comida_usuarios.domain.model.UserModel;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserRequestMapper {

    @Mapping(source = "userRequestDto.rolId", target = "rolId.id")
    UserModel toUser(UserRequestDto userRequestDto);
    UserResponseDto toDto(UserModel userModel);
    UserRequestDto toUserRequestDto(RegisterRequestDto registerRequestDto);

}
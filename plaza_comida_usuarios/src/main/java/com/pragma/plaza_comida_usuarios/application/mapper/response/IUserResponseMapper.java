package com.pragma.plaza_comida_usuarios.application.mapper.response;

import com.pragma.plaza_comida_usuarios.application.dto.response.RolResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.pragma.plaza_comida_usuarios.application.dto.response.UserResponseDto;
import com.pragma.plaza_comida_usuarios.domain.model.UserModel;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserResponseMapper {

    @Mapping(target = "rolId.name", source = "rolResponseDto.name")
    @Mapping(target = "rolId.description", source = "rolResponseDto.description")
    @Mapping(target = "name", source = "userModel.name")
    UserResponseDto toResponse(UserModel userModel, RolResponseDto rolResponseDto);
}

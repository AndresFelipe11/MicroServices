package com.pragma.plaza_comida_usuarios.application.mapper.response;


import com.pragma.plaza_comida_usuarios.application.dto.response.RolResponseDto;
import com.pragma.plaza_comida_usuarios.domain.model.RolModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRolResponseMapper {
    RolResponseDto toResponse(RolModel rolModel);
}
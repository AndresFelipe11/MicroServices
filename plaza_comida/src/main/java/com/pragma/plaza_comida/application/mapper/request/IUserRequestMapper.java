package com.pragma.plaza_comida.application.mapper.request;

import com.pragma.plaza_comida.application.dto.request.UserRequestDto;
import com.pragma.plaza_comida.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserRequestMapper {
    UserModel toUser(UserRequestDto userRequestDto);
}
package com.pragma.plaza_comida.infrastructure.out.mapper;

import com.pragma.plaza_comida.domain.model.UserModel;
import com.pragma.plaza_comida.infrastructure.out.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserEntityMapper {
    UserEntity toEntity(UserModel userModel);

    UserModel toUserModel(UserEntity userEntity);
}

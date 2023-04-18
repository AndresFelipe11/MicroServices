package com.pragma.plaza_comida_usuarios.infrastructure.out.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.pragma.plaza_comida_usuarios.domain.model.UserModel;
import com.pragma.plaza_comida_usuarios.infrastructure.out.jpa.entity.UserEntity;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserEntityMapper {
    UserEntity toEntity(UserModel userModel);

    UserModel toUserModel(UserEntity userEntity);

    List<UserModel> toUserModelList(List<UserEntity> userEntityList);
}

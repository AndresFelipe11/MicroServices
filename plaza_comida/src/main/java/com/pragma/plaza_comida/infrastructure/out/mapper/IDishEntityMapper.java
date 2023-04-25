package com.pragma.plaza_comida.infrastructure.out.mapper;



import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.pragma.plaza_comida.domain.model.DishModel;
import com.pragma.plaza_comida.infrastructure.out.entity.DishEntity;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IDishEntityMapper {

    DishEntity toEntity(DishModel dishModel);

    DishModel toDishModel(DishEntity dishEntity);

    List<DishModel> toDishModelList(List<DishEntity> dishEntityList);

}

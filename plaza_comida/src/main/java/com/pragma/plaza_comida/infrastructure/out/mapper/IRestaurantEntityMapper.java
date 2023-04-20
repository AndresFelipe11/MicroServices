package com.pragma.plaza_comida.infrastructure.out.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.pragma.plaza_comida.domain.model.RestaurantModel;
import com.pragma.plaza_comida.infrastructure.out.entity.RestaurantEntity;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantEntityMapper {

    RestaurantEntity toEntity(RestaurantModel restaurantModel);
    RestaurantModel toRestaurantModel(RestaurantEntity restaurantEntity);
    List<RestaurantModel> toRestaurantModelList(List<RestaurantEntity> restaurantEntityList);
}

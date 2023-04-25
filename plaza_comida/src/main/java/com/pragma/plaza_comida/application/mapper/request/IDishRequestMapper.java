package com.pragma.plaza_comida.application.mapper.request;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.pragma.plaza_comida.application.dto.request.DishRequestDto;
import com.pragma.plaza_comida.application.dto.request.DishUpdateRequestDto;
import com.pragma.plaza_comida.domain.model.CategoryModel;
import com.pragma.plaza_comida.domain.model.DishModel;
import com.pragma.plaza_comida.domain.model.RestaurantModel;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IDishRequestMapper {

    @Mapping(source = "dishRequestDto.categoryId", target = "categoryId.id")
    @Mapping(source = "dishRequestDto.restaurantId", target = "restaurantId.id")
    DishModel toDish(DishRequestDto dishRequestDto);

    DishModel toDish(DishUpdateRequestDto dishUpdateRequestDto);

    CategoryModel toCategory(DishRequestDto dishRequestDto);

    RestaurantModel toRestaurant(DishRequestDto dishRequestDto);

}

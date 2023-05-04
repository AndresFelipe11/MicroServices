package com.pragma.plaza_comida.application.mapper.response;

import com.pragma.plaza_comida.application.dto.response.AllRestaurantResponseDto;
import com.pragma.plaza_comida.application.dto.response.RestaurantResponseDto;
import com.pragma.plaza_comida.domain.model.RestaurantModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantResponseMapper {
    RestaurantResponseDto toResponse(RestaurantModel restaurantModel);

    List<AllRestaurantResponseDto> toResponseList(List<RestaurantModel> restaurantModels);
}


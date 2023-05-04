package com.pragma.plaza_comida.application.mapper.request;

import com.pragma.plaza_comida.application.dto.request.RestaurantEmployeeRequestDto;
import com.pragma.plaza_comida.domain.model.RestaurantEmployeeModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantEmployeeRequestMapper {
    @Mapping(source = "restaurantEmployeeRequestDto.restaurantId", target = "restaurantId.id")
    @Mapping(source = "restaurantEmployeeRequestDto.employeeId", target = "employeeId.id")
    RestaurantEmployeeModel toRestaurantEmployee(RestaurantEmployeeRequestDto restaurantEmployeeRequestDto);
}
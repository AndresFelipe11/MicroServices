package com.pragma.plaza_comida.application.mapper.request;

import com.pragma.plaza_comida.application.dto.request.OrderDishRequestDto;
import com.pragma.plaza_comida.domain.model.OrderDishModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IOrderDishRequestMapper {
    @Mapping(source = "orderDishRequest.dishId", target = "dishId.id")
    OrderDishModel toOrderDish(OrderDishRequestDto orderDishRequest);
}

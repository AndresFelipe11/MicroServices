package com.pragma.plaza_comida.application.mapper.response;

import com.pragma.plaza_comida.application.dto.response.OrderDishResponseDto;
import com.pragma.plaza_comida.domain.model.OrderDishModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {ICategoryResponseMapper.class, IRestaurantResponseMapper.class})
public interface IOrderDishResponseMapper {

    IDishResponseMapper DISH_RESPONSE_MAPPER = Mappers.getMapper(IDishResponseMapper.class);

    OrderDishResponseDto toResponse(OrderDishModel orderDishModel);

    List<OrderDishResponseDto> toResponseList(List<OrderDishModel> orderDishModelList);

    /*
    default List<OrderDishResponseDto> toResponseList(List<OrderDishModel> orderDishModelList) {
        return orderDishModelList.stream()
                .map(
                        orderDish -> {
                            OrderDishResponseDto orderDishResponseDto = new OrderDishResponseDto();

                            orderDishResponseDto.setAmount(orderDish.getAmount());

                            DishModel dishModel = orderDish.getDishId();

                            orderDishResponseDto.setDishId(DISH_RESPONSE_MAPPER.toResponse(dishModel, null, null));
                            return orderDishResponseDto;

                        }
                ).collect(Collectors.toList());
    }
    */

}

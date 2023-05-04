package com.pragma.plaza_comida.application.handler;

import com.pragma.plaza_comida.application.dto.request.OrderDishRequestDto;
import com.pragma.plaza_comida.application.dto.response.OrderDishResponseDto;

import java.util.List;

public interface IOrderDishHandler {
    OrderDishResponseDto createOrderDish(OrderDishRequestDto orderDishRequestDto, Long orderId);

    OrderDishResponseDto getOrderDish(Long orderDishId);

    List<OrderDishResponseDto> getAllOrderDishByOrder(Long orderId);
}
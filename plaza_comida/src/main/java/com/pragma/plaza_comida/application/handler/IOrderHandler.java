package com.pragma.plaza_comida.application.handler;

import com.pragma.plaza_comida.application.dto.request.OrderRequestDto;
import com.pragma.plaza_comida.application.dto.response.OrderResponseDto;
import com.pragma.plaza_comida.application.dto.response.OrderStateResponseDto;
import com.pragma.plaza_comida.domain.model.OrderState;

import java.util.List;

public interface IOrderHandler {
    OrderResponseDto createOrder(OrderRequestDto orderRequestDto);

    OrderResponseDto getOrder(Long orderId);

    List<OrderStateResponseDto> getAllOrdersByOrderState(OrderState orderState);

    OrderResponseDto asignAnOrder(Long orderId);
}
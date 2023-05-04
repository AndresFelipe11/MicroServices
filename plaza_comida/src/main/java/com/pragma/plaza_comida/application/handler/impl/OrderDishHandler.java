package com.pragma.plaza_comida.application.handler.impl;

import com.pragma.plaza_comida.application.dto.request.OrderDishRequestDto;
import com.pragma.plaza_comida.application.dto.response.OrderDishResponseDto;
import com.pragma.plaza_comida.application.handler.IOrderDishHandler;
import com.pragma.plaza_comida.application.mapper.request.IOrderDishRequestMapper;
import com.pragma.plaza_comida.application.mapper.response.IOrderDishResponseMapper;
import com.pragma.plaza_comida.domain.api.IDishServicePort;
import com.pragma.plaza_comida.domain.api.IOrderDishServicePort;
import com.pragma.plaza_comida.domain.api.IOrderServicePort;
import com.pragma.plaza_comida.domain.model.DishModel;
import com.pragma.plaza_comida.domain.model.OrderDishModel;
import com.pragma.plaza_comida.domain.model.OrderModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class OrderDishHandler implements IOrderDishHandler {

    private final IOrderDishServicePort orderDishServicePort;
    private final IOrderDishRequestMapper orderDishRequestMapper;
    private final IOrderDishResponseMapper orderDishResponseMapper;
    private final IDishServicePort dishServicePort;
    private final IOrderServicePort orderServicePort;

    @Override
    public OrderDishResponseDto createOrderDish(OrderDishRequestDto orderDishRequestDto, Long orderId) {
        DishModel dishModel = dishServicePort.getDish(orderDishRequestDto.getDishId());
        OrderModel orderModel = orderServicePort.getOrder(orderId);

        OrderDishModel orderDishModel = orderDishRequestMapper.toOrderDish(orderDishRequestDto);
        orderDishModel.setDishId(dishModel);
        orderDishModel.setOrderId(orderModel);

        orderDishServicePort.createOrderDish(orderDishModel);

        return orderDishResponseMapper.toResponse(orderDishModel);
    }

    @Override
    public OrderDishResponseDto getOrderDish(Long orderDishId) {
        OrderDishModel orderDishModel = orderDishServicePort.getOrderDish(orderDishId);
        return orderDishResponseMapper.toResponse(orderDishModel);
    }

    @Override
    public List<OrderDishResponseDto> getAllOrderDishByOrder(Long orderId) {
        return orderDishResponseMapper.toResponseList(orderDishServicePort.getAllOrderDishByOrder(orderId));
    }
}
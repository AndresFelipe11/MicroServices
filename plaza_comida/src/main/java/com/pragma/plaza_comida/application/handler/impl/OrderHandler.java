package com.pragma.plaza_comida.application.handler.impl;

import com.pragma.plaza_comida.application.dto.request.OrderDishRequestDto;
import com.pragma.plaza_comida.application.dto.request.OrderRequestDto;
import com.pragma.plaza_comida.application.dto.request.UserRequestDto;
import com.pragma.plaza_comida.application.dto.response.OrderDishResponseDto;
import com.pragma.plaza_comida.application.dto.response.OrderResponseDto;
import com.pragma.plaza_comida.application.dto.response.OrderStateResponseDto;
import com.pragma.plaza_comida.application.handler.IOrderDishHandler;
import com.pragma.plaza_comida.application.handler.IOrderHandler;
import com.pragma.plaza_comida.application.mapper.request.IOrderRequestMapper;
import com.pragma.plaza_comida.application.mapper.request.IUserRequestMapper;
import com.pragma.plaza_comida.application.mapper.response.IOrderDishResponseMapper;
import com.pragma.plaza_comida.application.mapper.response.IOrderResponseMapper;
import com.pragma.plaza_comida.domain.api.IOrderDishServicePort;
import com.pragma.plaza_comida.domain.api.IOrderServicePort;
import com.pragma.plaza_comida.domain.api.IRestaurantEmployeeServicePort;
import com.pragma.plaza_comida.domain.api.IRestaurantServicePort;
import com.pragma.plaza_comida.domain.model.*;
import com.pragma.plaza_comida.infrastructure.configuration.FeignClientInterceptorImp;
import com.pragma.plaza_comida.infrastructure.exeption.DishNotFoundInRestaurantException;
import com.pragma.plaza_comida.infrastructure.input.rest.Client.IUserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderHandler implements IOrderHandler {
    private final IOrderServicePort orderServicePort;
    private final IOrderRequestMapper orderRequestMapper;
    private final IOrderResponseMapper orderResponseMapper;
    private final IOrderDishResponseMapper orderDishResponseMapper;
    private final IOrderDishServicePort orderDishServicePort;
    private final IRestaurantServicePort restaurantServicePort;
    private final IOrderDishHandler orderDishHandler;
    private final IRestaurantEmployeeServicePort restaurantEmployeeServicePort;
    private final JwtHandler jwtHandler;
    private final IUserClient userClient;
    private final IUserRequestMapper userRequestMapper;

    @Override
    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {
        RestaurantModel restaurantModel = restaurantServicePort.getRestaurant(orderRequestDto.getRestaurantId());
        String tokenHeader = FeignClientInterceptorImp.getBearerTokenHeader();
        String[] splited = tokenHeader.split("\\s+");
        String email = jwtHandler.extractUserName(splited[1]);
        UserRequestDto userRequestDto = userClient.getUserByEmail(email).getBody().getData();
        List<OrderState> orderStateList = Arrays.asList(OrderState.EN_PREPARACION, OrderState.PENDIENTE, OrderState.LISTO);

        orderServicePort.getAllOrdersByUserIdOrderStateIn(userRequestDto.getId(), orderStateList);

        OrderModel orderModel = new OrderModel();
        orderModel.setClientId(userRequestMapper.toUser(userRequestDto));
        orderModel.setDate(new Date());
        orderModel.setOrderState(OrderState.PENDIENTE);
        orderModel.setChefId(null);
        orderModel.setRestaurantId(restaurantModel);

        OrderModel orderModelResponse = orderServicePort.createOrder(orderModel);

        List<OrderDishRequestDto> orderDishRequestDtoList = orderRequestDto.getOrders();

        List<OrderDishResponseDto> orderDishResponseDtoList =
                orderDishRequestDtoList.stream()
                        .map(orderDish -> {

                            if (!Objects.equals(orderDish.getDishId(), restaurantModel.getId())) {
                                throw new DishNotFoundInRestaurantException();
                            }

                            return orderDishHandler.createOrderDish(orderDish, orderModelResponse.getId());
                        }).collect(Collectors.toList());

        return orderResponseMapper.toResponse(orderModelResponse, orderDishResponseDtoList);
    }

    @Override
    public OrderResponseDto getOrder(Long orderId) {
        return null;
    }

    @Override
    public List<OrderStateResponseDto> getAllOrdersByOrderState(OrderState orderState) {
        String tokenHeader = FeignClientInterceptorImp.getBearerTokenHeader();
        String[] splited = tokenHeader.split("\\s+");
        String email = jwtHandler.extractUserName(splited[1]);
        UserRequestDto userRequestDto = userClient.getUserByEmail(email).getBody().getData();

        RestaurantEmployeeModel restaurantEmployeeModel = restaurantEmployeeServicePort.getRestaurantByEmployeeId(userRequestDto.getId());

        return orderResponseMapper.toReponseList(orderServicePort.getAllOrdersByOrderState(orderState, restaurantEmployeeModel.getRestaurantId().getId()), restaurantServicePort.getAllRestaurants(), orderDishServicePort.getAllOrderDish());
    }

    @Override
    public OrderResponseDto asignAnOrder(Long orderId) {
        OrderModel orderModel = orderServicePort.getOrder(orderId);

        String tokenHeader = FeignClientInterceptorImp.getBearerTokenHeader();
        String[] splited = tokenHeader.split("\\s+");
        String email = jwtHandler.extractUserName(splited[1]);
        UserRequestDto userRequestDto = userClient.getUserByEmail(email).getBody().getData();

        orderModel.setChefId(userRequestMapper.toUser(userRequestDto));
        orderModel.setOrderState(OrderState.EN_PREPARACION);

        OrderModel orderModelResponse = orderServicePort.createOrder(orderModel);

        List<OrderDishModel> orderDishModelList = orderDishServicePort.getAllOrderDishByOrder(orderId);

        List<OrderDishResponseDto> orderDishResponseDtoList = orderDishModelList.stream().map(orderDishResponseMapper::toResponse).collect(Collectors.toList());

        return orderResponseMapper.toResponse(orderModelResponse, orderDishResponseDtoList);
    }

}

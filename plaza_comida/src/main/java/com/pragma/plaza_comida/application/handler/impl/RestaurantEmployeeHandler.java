package com.pragma.plaza_comida.application.handler.impl;

import com.pragma.plaza_comida.application.dto.request.RestaurantEmployeeRequestDto;
import com.pragma.plaza_comida.application.dto.response.RestaurantEmployeeResponseDto;
import com.pragma.plaza_comida.application.handler.IRestaurantEmployeeHandler;
import com.pragma.plaza_comida.application.mapper.request.IRestaurantEmployeeRequestMapper;
import com.pragma.plaza_comida.application.mapper.response.IRestaurantEmployeeResponseMapper;
import com.pragma.plaza_comida.domain.api.IRestaurantEmployeeServicePort;
import com.pragma.plaza_comida.domain.api.IRestaurantServicePort;
import com.pragma.plaza_comida.domain.model.RestaurantEmployeeModel;
import com.pragma.plaza_comida.domain.model.RestaurantModel;
import com.pragma.plaza_comida.infrastructure.exeption.NotEnoughPrivileges;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RestaurantEmployeeHandler implements IRestaurantEmployeeHandler {

    private final IRestaurantEmployeeServicePort restaurantEmployeeServicePort;
    private final IRestaurantEmployeeRequestMapper restaurantEmployeeRequestMapper;
    private final IRestaurantEmployeeResponseMapper restaurantEmployeeResponseMapper;
    private final IRestaurantServicePort restaurantServicePort;

    @Override
    public RestaurantEmployeeResponseDto saveRestaurantEmployee(RestaurantEmployeeRequestDto restaurantEmployeeRequestDto) {

        RestaurantModel restaurantModel = restaurantServicePort.getRestaurant(restaurantEmployeeRequestDto.getRestaurantId());
        if (!restaurantModel.getOwnerId().equals(restaurantEmployeeRequestDto.getOwnerId())) {
            throw new NotEnoughPrivileges();
        }

        RestaurantEmployeeModel restaurantEmployeeModel = restaurantEmployeeRequestMapper.toRestaurantEmployee(restaurantEmployeeRequestDto);
        return restaurantEmployeeResponseMapper.toResponse(restaurantEmployeeServicePort.saveRestaurantEmployee(restaurantEmployeeModel));
    }

    @Override
    public RestaurantEmployeeResponseDto getRestaurantEmployee(Long restaurantEmployeeId) {
        RestaurantEmployeeModel restaurantEmployeeModel = restaurantEmployeeServicePort.getRestaurantEmployee(restaurantEmployeeId);
        return restaurantEmployeeResponseMapper.toResponse(restaurantEmployeeModel);
    }
}

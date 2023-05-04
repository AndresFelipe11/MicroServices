package com.pragma.plaza_comida.application.handler;


import com.pragma.plaza_comida.application.dto.request.RestaurantEmployeeRequestDto;
import com.pragma.plaza_comida.application.dto.response.RestaurantEmployeeResponseDto;

public interface IRestaurantEmployeeHandler {
    RestaurantEmployeeResponseDto saveRestaurantEmployee(RestaurantEmployeeRequestDto restaurantEmployeeRequestDto);

    RestaurantEmployeeResponseDto getRestaurantEmployee(Long restaurantEmployeeId);
}

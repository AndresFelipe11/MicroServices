package com.pragma.plaza_comida.application.handler;

import com.pragma.plaza_comida.application.dto.request.RestaurantRequestDto;
import com.pragma.plaza_comida.application.dto.response.RestaurantResponseDto;

import java.util.List;

public interface IRestaurantHandler {

    void saveRestaurant(RestaurantRequestDto restaurantRequestDto);

    List<RestaurantResponseDto> getAllRestaurants();

}
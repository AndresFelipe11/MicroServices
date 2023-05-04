package com.pragma.plaza_comida.application.handler;

import com.pragma.plaza_comida.application.dto.request.ListPaginationRequest;
import com.pragma.plaza_comida.application.dto.request.RestaurantRequestDto;
import com.pragma.plaza_comida.application.dto.response.AllRestaurantResponseDto;
import com.pragma.plaza_comida.application.dto.response.RestaurantResponseDto;

import java.util.List;

public interface IRestaurantHandler {
    RestaurantResponseDto saveRestaurant(RestaurantRequestDto restaurantRequestDto);

    List<AllRestaurantResponseDto> getAllRestaurants(ListPaginationRequest listPaginationRequest);

    List<AllRestaurantResponseDto> getAllRestaurants();

}
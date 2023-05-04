package com.pragma.plaza_comida.application.handler.impl;

import com.pragma.plaza_comida.application.dto.request.ListPaginationRequest;
import com.pragma.plaza_comida.application.dto.request.UserRequestDto;
import com.pragma.plaza_comida.application.dto.response.AllRestaurantResponseDto;
import com.pragma.plaza_comida.infrastructure.exeption.NoUserFoundException;
import com.pragma.plaza_comida.infrastructure.input.rest.Client.IUserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.pragma.plaza_comida.application.dto.request.RestaurantRequestDto;
import com.pragma.plaza_comida.application.dto.response.RestaurantResponseDto;
import com.pragma.plaza_comida.application.handler.IRestaurantHandler;
import com.pragma.plaza_comida.application.mapper.request.IRestaurantRequestMapper;
import com.pragma.plaza_comida.application.mapper.response.IRestaurantResponseMapper;
import com.pragma.plaza_comida.domain.api.IRestaurantServicePort;
import com.pragma.plaza_comida.domain.model.RestaurantModel;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RestaurantHandler implements IRestaurantHandler {

    private final IRestaurantServicePort restaurantServicePort;
    private final IRestaurantRequestMapper restaurantRequestMapper;
    private final IRestaurantResponseMapper restaurantResponseMapper;

    private final IUserClient userClient;

    @Override
    public RestaurantResponseDto saveRestaurant(RestaurantRequestDto restaurantRequestDto) {
        RestaurantModel restaurantModel = restaurantRequestMapper.toRestaurant(restaurantRequestDto);
        UserRequestDto userRequestDto = userClient.getUserById(Long.valueOf(restaurantModel.getOwnerId())).getBody().getData();

        if (userRequestDto == null) {
            throw new NoUserFoundException();
        }

        restaurantModel.setOwnerId(String.valueOf(restaurantRequestDto.getOwnerId()));
        RestaurantModel restaurant = restaurantServicePort.saveRestaurant(restaurantModel);
        return restaurantResponseMapper.toResponse(restaurantServicePort.getRestaurant(restaurant.getId()));
    }

    @Override
    public List<AllRestaurantResponseDto> getAllRestaurants(ListPaginationRequest listPaginationRequest) {
        return restaurantResponseMapper.toResponseList(restaurantServicePort.getAllRestaurants(listPaginationRequest.getPageN(), listPaginationRequest.getSize()));
    }

    @Override
    public List<AllRestaurantResponseDto> getAllRestaurants() {
        return restaurantResponseMapper.toResponseList(restaurantServicePort.getAllRestaurants());
    }
}
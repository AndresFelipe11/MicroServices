package com.pragma.plaza_comida.domain.api;

import com.pragma.plaza_comida.domain.model.RestaurantEmployeeModel;

import java.util.List;

public interface IRestaurantEmployeeServicePort {
    RestaurantEmployeeModel saveRestaurantEmployee(RestaurantEmployeeModel restaurantEmployeeModel);

    RestaurantEmployeeModel getRestaurantEmployee(Long restaurantEmployeeId);

    RestaurantEmployeeModel getRestaurantByEmployeeId(Long employeeId);
}
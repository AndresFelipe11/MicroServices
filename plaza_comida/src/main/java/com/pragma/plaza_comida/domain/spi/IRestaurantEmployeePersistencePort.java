package com.pragma.plaza_comida.domain.spi;

import com.pragma.plaza_comida.domain.model.RestaurantEmployeeModel;

import java.util.List;

public interface IRestaurantEmployeePersistencePort {
    RestaurantEmployeeModel saveRestaurantEmployee(RestaurantEmployeeModel restaurantEmployeeModel);

    RestaurantEmployeeModel getRestaurantEmployee(Long restaurantEmployeeId);

    RestaurantEmployeeModel getRestaurantByEmployeeId(Long employeeId);
}
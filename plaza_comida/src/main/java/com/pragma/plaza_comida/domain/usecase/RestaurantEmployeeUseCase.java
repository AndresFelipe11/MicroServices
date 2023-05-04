package com.pragma.plaza_comida.domain.usecase;

import com.pragma.plaza_comida.domain.api.IRestaurantEmployeeServicePort;
import com.pragma.plaza_comida.domain.model.RestaurantEmployeeModel;
import com.pragma.plaza_comida.domain.spi.IRestaurantEmployeePersistencePort;

import java.util.List;

public class RestaurantEmployeeUseCase implements IRestaurantEmployeeServicePort {

    private final IRestaurantEmployeePersistencePort restaurantEmployeePersistencePort;

    public RestaurantEmployeeUseCase(IRestaurantEmployeePersistencePort restaurantEmployeePersistencePort) {
        this.restaurantEmployeePersistencePort = restaurantEmployeePersistencePort;
    }

    @Override
    public RestaurantEmployeeModel saveRestaurantEmployee(RestaurantEmployeeModel restaurantEmployeeModel) {
        return restaurantEmployeePersistencePort.saveRestaurantEmployee(restaurantEmployeeModel);
    }

    @Override
    public RestaurantEmployeeModel getRestaurantEmployee(Long restaurantEmployeeId) {
        return restaurantEmployeePersistencePort.getRestaurantEmployee(restaurantEmployeeId);
    }

    @Override
    public RestaurantEmployeeModel getRestaurantByEmployeeId(Long employeeId) {
        return restaurantEmployeePersistencePort.getRestaurantByEmployeeId(employeeId);
    }
}

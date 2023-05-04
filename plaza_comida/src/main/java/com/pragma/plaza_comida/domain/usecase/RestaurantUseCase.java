package com.pragma.plaza_comida.domain.usecase;

import java.util.List;

import com.pragma.plaza_comida.domain.api.IRestaurantServicePort;
import com.pragma.plaza_comida.domain.model.RestaurantModel;
import com.pragma.plaza_comida.domain.spi.IRestaurantPersistencePort;

public class RestaurantUseCase implements IRestaurantServicePort {

    private final IRestaurantPersistencePort restaurantPersistencePort;

    public RestaurantUseCase(IRestaurantPersistencePort restaurantPersistencePort) {
        this.restaurantPersistencePort = restaurantPersistencePort;
    }


    @Override
    public RestaurantModel saveRestaurant(RestaurantModel restaurantModel) {
        return restaurantPersistencePort.saveRestaurant(restaurantModel);
    }

    @Override
    public RestaurantModel getRestaurant(Long restaurantId) {
        return restaurantPersistencePort.getRestaurant(restaurantId);
    }

    @Override
    public List<RestaurantModel> getAllRestaurants(int pageN, int size) {
        return restaurantPersistencePort.getAllRestaurants(pageN, size);
    }

    @Override
    public List<RestaurantModel> getAllRestaurants() {
        return restaurantPersistencePort.getAllRestaurants();
    }
}

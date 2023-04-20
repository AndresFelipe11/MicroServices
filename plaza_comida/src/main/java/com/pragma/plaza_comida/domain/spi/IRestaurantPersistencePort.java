package com.pragma.plaza_comida.domain.spi;

import java.util.List;

import com.pragma.plaza_comida.domain.model.RestaurantModel;

public interface IRestaurantPersistencePort {
    RestaurantModel saveRestaurant(RestaurantModel restaurantModel);

    RestaurantModel getRestaurant(Long restaurantId);

    List<RestaurantModel> getAllRestaurants();
}

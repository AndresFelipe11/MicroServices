package com.pragma.plaza_comida.domain.api;

import java.util.List;

import com.pragma.plaza_comida.domain.model.RestaurantModel;

public interface IRestaurantServicePort {
    RestaurantModel saveRestaurant(RestaurantModel restaurantModel);

    RestaurantModel getRestaurant(Long restaurantId);

    List<RestaurantModel> getAllRestaurants();
}

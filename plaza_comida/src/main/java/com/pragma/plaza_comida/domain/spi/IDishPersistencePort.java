package com.pragma.plaza_comida.domain.spi;

import java.util.List;

import com.pragma.plaza_comida.domain.model.DishModel;

public interface IDishPersistencePort {
    DishModel saveDish(DishModel dishModel);

    DishModel getDish(Long dishId);

    List<DishModel> getAllDishes();

    void updateDish(DishModel dishModel);

    List<DishModel> getAllDishesByRestaurant(int pageN, int size, Long restaurantId);
}

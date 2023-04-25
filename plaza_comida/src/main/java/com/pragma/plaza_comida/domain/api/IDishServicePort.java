package com.pragma.plaza_comida.domain.api;

import java.util.List;

import com.pragma.plaza_comida.domain.model.DishModel;

public interface IDishServicePort {
    DishModel saveDish(DishModel dishModel);

    DishModel getDish(Long dishId);

    List<DishModel> getAllDishes();

    void updateDish(DishModel dishModel);
}

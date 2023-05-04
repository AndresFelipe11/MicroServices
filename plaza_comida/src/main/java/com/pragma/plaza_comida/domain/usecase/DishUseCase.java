package com.pragma.plaza_comida.domain.usecase;

import java.util.List;

import com.pragma.plaza_comida.domain.api.IDishServicePort;
import com.pragma.plaza_comida.domain.model.DishModel;
import com.pragma.plaza_comida.domain.spi.IDishPersistencePort;

public class DishUseCase implements IDishServicePort {

    private final IDishPersistencePort dishPersistencePort;

    public DishUseCase(IDishPersistencePort dishPersistencePort) {
        this.dishPersistencePort = dishPersistencePort;
    }

    @Override
    public DishModel saveDish(DishModel dishModel) {
        dishPersistencePort.saveDish(dishModel);
        return dishModel;
    }

    @Override
    public List<DishModel> getAllDishes() {
        return dishPersistencePort.getAllDishes();
    }

    @Override
    public DishModel getDish(Long dishId) {
        return dishPersistencePort.getDish(dishId);
    }

    @Override
    public void updateDish(DishModel dishModel) {
        dishPersistencePort.updateDish(dishModel);
    }

    @Override
    public List<DishModel> getAllDishesByRestaurant(int pageN, int size, Long restaurantId) {
        return dishPersistencePort.getAllDishesByRestaurant(pageN, size, restaurantId);
    }
}

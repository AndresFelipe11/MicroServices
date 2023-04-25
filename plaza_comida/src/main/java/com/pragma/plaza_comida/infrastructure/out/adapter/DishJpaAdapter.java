package com.pragma.plaza_comida.infrastructure.out.adapter;

import lombok.RequiredArgsConstructor;

import java.util.List;

import com.pragma.plaza_comida.domain.model.DishModel;
import com.pragma.plaza_comida.domain.spi.IDishPersistencePort;
import com.pragma.plaza_comida.infrastructure.exeption.DishNotFoundException;
import com.pragma.plaza_comida.infrastructure.exeption.NoDataFoundException;
import com.pragma.plaza_comida.infrastructure.out.entity.DishEntity;
import com.pragma.plaza_comida.infrastructure.out.mapper.IDishEntityMapper;
import com.pragma.plaza_comida.infrastructure.out.repository.IDishRepository;

@RequiredArgsConstructor
public class DishJpaAdapter implements IDishPersistencePort {

    private final IDishRepository dishRepository;
    private final IDishEntityMapper dishEntityMapper;

    @Override
    public DishModel saveDish(DishModel dishModel) {
        DishModel dish = dishModel;

        dish.setActive(true);

        dishRepository.save(dishEntityMapper.toEntity(dish));
        return dish;
    }

    @Override
    public List<DishModel> getAllDishes() {
        List<DishEntity> dishEntityList = dishRepository.findAll();

        if (dishEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }

        return dishEntityMapper.toDishModelList(dishEntityList);
    }

    @Override
    public DishModel getDish(Long dishId) {
        return dishEntityMapper.toDishModel(dishRepository.findById(dishId).orElseThrow(DishNotFoundException::new));
    }


    @Override
    public void updateDish(DishModel dishModel) {
        dishRepository.save(dishEntityMapper.toEntity(dishModel));
    }
}

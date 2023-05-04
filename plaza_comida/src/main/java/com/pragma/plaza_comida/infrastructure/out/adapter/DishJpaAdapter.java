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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

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
        List<DishEntity> dishEntityList = (List<DishEntity>) dishRepository.findAll();

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

    @Override
    public List<DishModel> getAllDishesByRestaurant(int pageN, int size, Long restaurantId) {
        PageRequest pagingSort = PageRequest.of(pageN, size, Sort.by("categoryId.name"));
        Page<DishEntity> page = dishRepository.findAllByRestaurantId(restaurantId, pagingSort);
        List<DishEntity> dishEntityList = page.getContent();

        if (dishEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }

        return dishEntityMapper.toDishModelList(dishEntityList);
    }
}

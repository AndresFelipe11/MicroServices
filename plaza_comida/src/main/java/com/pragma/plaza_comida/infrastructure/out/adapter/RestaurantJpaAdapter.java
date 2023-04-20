package com.pragma.plaza_comida.infrastructure.out.adapter;

import lombok.RequiredArgsConstructor;

import java.util.List;

import com.pragma.plaza_comida.domain.model.RestaurantModel;
import com.pragma.plaza_comida.domain.spi.IRestaurantPersistencePort;
import com.pragma.plaza_comida.infrastructure.exeption.NoDataFoundException;
import com.pragma.plaza_comida.infrastructure.exeption.RestaurantNotFoundException;
import com.pragma.plaza_comida.infrastructure.out.entity.RestaurantEntity;
import com.pragma.plaza_comida.infrastructure.out.mapper.IRestaurantEntityMapper;
import com.pragma.plaza_comida.infrastructure.out.repository.IRestaurantRepository;

@RequiredArgsConstructor
public class RestaurantJpaAdapter implements IRestaurantPersistencePort {

    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantEntityMapper restaurantEntityMapper;


    @Override
    public RestaurantModel saveRestaurant(RestaurantModel restaurantModel) {
        RestaurantEntity restaurantEntity = restaurantRepository.save(restaurantEntityMapper.toEntity(restaurantModel));
        return restaurantEntityMapper.toRestaurantModel(restaurantEntity);
    }

    @Override
    public RestaurantModel getRestaurant(Long restaurantId) {
        return restaurantEntityMapper.toRestaurantModel(restaurantRepository.findById(restaurantId).orElseThrow(RestaurantNotFoundException::new));
    }

    @Override
    public List<RestaurantModel> getAllRestaurants() {
        List<RestaurantEntity> entityList = restaurantRepository.findAll();

        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return restaurantEntityMapper.toRestaurantModelList(entityList);
    }
}

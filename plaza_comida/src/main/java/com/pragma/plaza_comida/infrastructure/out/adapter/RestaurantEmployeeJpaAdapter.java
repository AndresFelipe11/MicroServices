package com.pragma.plaza_comida.infrastructure.out.adapter;

import com.pragma.plaza_comida.domain.model.RestaurantEmployeeModel;
import com.pragma.plaza_comida.domain.spi.IRestaurantEmployeePersistencePort;
import com.pragma.plaza_comida.infrastructure.exeption.NoDataFoundException;
import com.pragma.plaza_comida.infrastructure.out.entity.RestaurantEmployeeEntity;
import com.pragma.plaza_comida.infrastructure.out.mapper.IRestaurantEmployeeEntityMapper;
import com.pragma.plaza_comida.infrastructure.out.repository.IRestaurantEmployeeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RestaurantEmployeeJpaAdapter implements IRestaurantEmployeePersistencePort {

    private final IRestaurantEmployeeRepository restaurantEmployeeRepository;
    private final IRestaurantEmployeeEntityMapper restaurantEmployeeEntityMapper;

    @Override
    public RestaurantEmployeeModel saveRestaurantEmployee(RestaurantEmployeeModel restaurantEmployeeModel) {
        RestaurantEmployeeEntity restaurantEmployeeEntity = restaurantEmployeeRepository.save(restaurantEmployeeEntityMapper.toEntity(restaurantEmployeeModel));
        return restaurantEmployeeEntityMapper.toModel(restaurantEmployeeEntity);
    }

    @Override
    public RestaurantEmployeeModel getRestaurantEmployee(Long restaurantEmployeeId) {
        return restaurantEmployeeEntityMapper.toModel(restaurantEmployeeRepository.findById(restaurantEmployeeId).orElseThrow(NoDataFoundException::new));
    }

    @Override
    public RestaurantEmployeeModel getRestaurantByEmployeeId(Long employeeId) {
        return restaurantEmployeeEntityMapper.toModel(restaurantEmployeeRepository.findFirstRestaurantEmployeeByEmployeeId(employeeId));
    }
}
package com.pragma.plaza_comida.infrastructure.out.repository;

import com.pragma.plaza_comida.infrastructure.out.entity.RestaurantEmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRestaurantEmployeeRepository extends JpaRepository<RestaurantEmployeeEntity, Long> {

    RestaurantEmployeeEntity findFirstRestaurantEmployeeByEmployeeId(Long employeeId);

}

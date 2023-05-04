package com.pragma.plaza_comida.infrastructure.out.repository;


import com.pragma.plaza_comida.infrastructure.out.entity.RestaurantEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRestaurantRepository extends PagingAndSortingRepository<RestaurantEntity, Long> {
    Page<RestaurantEntity> findAll(Pageable pageable);
}

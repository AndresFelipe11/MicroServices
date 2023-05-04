package com.pragma.plaza_comida.infrastructure.out.repository;



import com.pragma.plaza_comida.infrastructure.out.entity.DishEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IDishRepository extends PagingAndSortingRepository<DishEntity, Long> {
    @Query("SELECT d FROM DishEntity d WHERE d.restaurantId.id = :restaurantId")
    Page<DishEntity> findAllByRestaurantId(@Param("restaurantId") Long restaurantId, Pageable pageable);

    Page<DishEntity> findAll(Pageable pageable);
}

package com.pragma.plaza_comida.infrastructure.out.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.pragma.plaza_comida.infrastructure.out.entity.DishEntity;

import java.util.Optional;

public interface IDishRepository extends JpaRepository<DishEntity, Long> {
}

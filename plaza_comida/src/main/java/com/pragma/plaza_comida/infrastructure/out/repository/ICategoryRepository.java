package com.pragma.plaza_comida.infrastructure.out.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.pragma.plaza_comida.infrastructure.out.entity.CategoryEntity;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
}

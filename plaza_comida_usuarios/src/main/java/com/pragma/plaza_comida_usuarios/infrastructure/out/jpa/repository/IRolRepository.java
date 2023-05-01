package com.pragma.plaza_comida_usuarios.infrastructure.out.jpa.repository;

import com.pragma.plaza_comida_usuarios.infrastructure.out.jpa.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolRepository extends JpaRepository<RolEntity, Long> {
}
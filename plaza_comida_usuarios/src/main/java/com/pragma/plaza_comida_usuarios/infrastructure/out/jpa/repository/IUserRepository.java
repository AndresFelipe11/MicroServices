package com.pragma.plaza_comida_usuarios.infrastructure.out.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pragma.plaza_comida_usuarios.infrastructure.out.jpa.entity.UserEntity;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
}

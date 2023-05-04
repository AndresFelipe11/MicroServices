package com.pragma.plaza_comida.infrastructure.out.repository;

import com.pragma.plaza_comida.infrastructure.out.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}

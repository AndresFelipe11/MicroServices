package com.pragma.plaza_comida.infrastructure.out.repository;

import com.pragma.plaza_comida.domain.model.OrderState;
import com.pragma.plaza_comida.infrastructure.out.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IOrderRepository extends JpaRepository<OrderEntity, Long> {

    @Query("SELECT o FROM OrderEntity o WHERE o.orderState = :orderState AND o.restaurantId.id = :restaurantId")
    List<OrderEntity> findAllByOrderState(OrderState orderState, Long restaurantId);

    Optional<OrderEntity> findByClientIdAndOrderStateIn(Long clientId, List<OrderState> orderStateList);

}

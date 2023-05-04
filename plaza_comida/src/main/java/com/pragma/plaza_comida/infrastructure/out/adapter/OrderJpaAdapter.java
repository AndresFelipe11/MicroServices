package com.pragma.plaza_comida.infrastructure.out.adapter;

import com.pragma.plaza_comida.domain.model.OrderModel;
import com.pragma.plaza_comida.domain.model.OrderState;
import com.pragma.plaza_comida.domain.spi.IOrderPersistencePort;
import com.pragma.plaza_comida.infrastructure.exeption.OrderNotFoundException;
import com.pragma.plaza_comida.infrastructure.exeption.UserCannotMakeAnOrderException;
import com.pragma.plaza_comida.infrastructure.out.entity.OrderEntity;
import com.pragma.plaza_comida.infrastructure.out.mapper.IOrderEntityMapper;
import com.pragma.plaza_comida.infrastructure.out.repository.IOrderRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class OrderJpaAdapter implements IOrderPersistencePort {

    private final IOrderRepository orderRepository;
    private final IOrderEntityMapper orderEntityMapper;

    @Override
    public OrderModel createOrder(OrderModel orderModel) {
        return orderEntityMapper.toOrderModel(orderRepository.save(orderEntityMapper.toOrderEntity(orderModel)));
    }

    @Override
    public OrderModel getOrder(Long orderId) {
        return orderEntityMapper.toOrderModel(orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new));
    }

    @Override
    public List<OrderModel> getAllOrdersByOrderState(OrderState orderState, Long restaurantId) {
        return orderEntityMapper.toOrderModelList(orderRepository.findAllByOrderState(orderState, restaurantId));
    }

    @Override
    public Boolean getAllOrdersByUserIdOrderStateIn(Long clientId, List<OrderState> orderStateList) {
        Optional<OrderEntity> orderEntityOptional = orderRepository.findByClientIdAndOrderStateIn(clientId, orderStateList);

        if (!orderEntityOptional.isEmpty()) {
            throw new UserCannotMakeAnOrderException();
        }

        return true;
    }
}

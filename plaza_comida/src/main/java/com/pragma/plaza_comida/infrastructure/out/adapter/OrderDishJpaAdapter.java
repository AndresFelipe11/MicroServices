package com.pragma.plaza_comida.infrastructure.out.adapter;

import com.pragma.plaza_comida.domain.model.OrderDishModel;
import com.pragma.plaza_comida.domain.spi.IOrderDishPersistencePort;
import com.pragma.plaza_comida.infrastructure.out.entity.OrderDishEntity;
import com.pragma.plaza_comida.infrastructure.out.mapper.IOrderDishEntityMapper;
import com.pragma.plaza_comida.infrastructure.out.repository.IOrderDishRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class OrderDishJpaAdapter implements IOrderDishPersistencePort {

    private final IOrderDishRepository orderDishRepository;
    private final IOrderDishEntityMapper orderDishEntityMapper;

    @Override
    public OrderDishModel createOrderDish(OrderDishModel orderDishModel) {
        return orderDishEntityMapper.toOrderDishModel(orderDishRepository.save(orderDishEntityMapper.toOrderDishEntity(orderDishModel)));
    }

    @Override
    public OrderDishModel getOrderDish(Long orderDishId) {
        return null;
    }

    @Override
    public List<OrderDishModel> getAllOrderDish() {
        return orderDishEntityMapper.toOrderDishModelList(orderDishRepository.findAll());
    }

    @Override
    public List<OrderDishModel> getAllOrderDishByOrder(Long orderId) {
        List<OrderDishEntity> orderDishEntityList = orderDishRepository.findAllByOrderId(orderId);
        return orderDishEntityMapper.toOrderDishModelList(orderDishEntityList);
    }
}
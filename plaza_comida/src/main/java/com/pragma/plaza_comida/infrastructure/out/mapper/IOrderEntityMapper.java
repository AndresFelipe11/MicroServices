package com.pragma.plaza_comida.infrastructure.out.mapper;

import com.pragma.plaza_comida.domain.model.OrderModel;
import com.pragma.plaza_comida.infrastructure.out.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IOrderEntityMapper {

    @Mapping(source = "orderModel.clientId.id", target = "clientId")
    @Mapping(source = "orderModel.chefId.id", target = "chefId")
    OrderEntity toOrderEntity(OrderModel orderModel);

    @Mapping(source = "clientId", target = "clientId.id")
    @Mapping(source = "chefId", target = "chefId.id")
    OrderModel toOrderModel(OrderEntity orderEntity);

    List<OrderModel> toOrderModelList(List<OrderEntity> orderEntityList);

}
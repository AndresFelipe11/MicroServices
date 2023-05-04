package com.pragma.plaza_comida.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDishResponseDto {
    private DishResponseDto dishId;
    private Integer amount;
}

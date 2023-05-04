package com.pragma.plaza_comida.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantEmployeeRequestDto {
    private Long restaurantId;
    private Long employeeId;
    private String field;
    private Long ownerId;
}

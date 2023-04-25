package com.pragma.plaza_comida.application.dto.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishResponseDto {
    private String name;
    private CategoryResponseDto categoryId;
    private String description;
    private Float price;
    private RestaurantResponseDto restaurantId;
    private String urlImage;
    private Boolean active;
}

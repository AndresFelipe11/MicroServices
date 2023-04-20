package com.pragma.plaza_comidas.infrastructure.input.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.pragma.plaza_comida.application.handler.IRestaurantHandler;

@ExtendWith(SpringExtension.class)
class RestaurantRestControllerTest {

    @InjectMocks
    IRestaurantHandler restaurantHandler;

    @Test
    void mustSaveRestaurant() {


    }


}
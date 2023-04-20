package com.pragma.plaza_comidas.application.handler.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.pragma.factory.FactoryRestaurantDataTest;
import com.pragma.plaza_comida.application.dto.request.RestaurantRequestDto;
import com.pragma.plaza_comida.application.handler.impl.RestaurantHandler;
import com.pragma.plaza_comida.application.mapper.request.IRestaurantRequestMapper;
import com.pragma.plaza_comida.application.mapper.response.IRestaurantResponseMapper;
import com.pragma.plaza_comida.domain.api.IRestaurantServicePort;
import com.pragma.plaza_comida.domain.model.RestaurantModel;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class RestaurantHandlerTest {
    @InjectMocks
    RestaurantHandler restaurantHandler;
    @Mock
    IRestaurantServicePort restaurantServicePort;
    @Mock
    IRestaurantRequestMapper restaurantRequestMapper;
    @Mock
    IRestaurantResponseMapper restaurantResponseMapper;

    @Test
    void mustSaveARestaurant() {
        //Given
        RestaurantModel expectedRestaurant = FactoryRestaurantDataTest.getRestaurantModel();

        RestaurantRequestDto restaurantRequestDto = FactoryRestaurantDataTest.getRestaurantRequestDto();

        //When

        when(restaurantRequestMapper.toRestaurant(any())).thenReturn(expectedRestaurant);

        restaurantHandler.saveRestaurant(restaurantRequestDto);

        //Then

        verify(restaurantServicePort).saveRestaurant(any(RestaurantModel.class));
    }

    @Test
    void invalidPhoneFormat() {
        Validator validator = FactoryRestaurantDataTest.getValidator();

        RestaurantRequestDto restaurantInvalidPhoneFormat = FactoryRestaurantDataTest.getRestaurantBadPhoneNumber();

        Set<ConstraintViolation<RestaurantRequestDto>> violations = validator.validate(restaurantInvalidPhoneFormat);

        assertFalse(violations.isEmpty());
    }

    @Test
    void invalidRequestNameMustBeNotNull() {
        Validator validator = FactoryRestaurantDataTest.getValidator();

        RestaurantRequestDto restaurantWithoutName = FactoryRestaurantDataTest.getRestaurantWithoutName();

        Set<ConstraintViolation<RestaurantRequestDto>> violations = validator.validate(restaurantWithoutName);

        assertFalse(violations.isEmpty());
    }

    @Test
    void invalidRequestNameAllNumericName() {
        Validator validator = FactoryRestaurantDataTest.getValidator();

        RestaurantRequestDto restaurantWhitAllNumberName = FactoryRestaurantDataTest.getRestaurantInvalidName();

        Set<ConstraintViolation<RestaurantRequestDto>> violations = validator.validate(restaurantWhitAllNumberName);

        assertFalse(violations.isEmpty());
    }

}
package com.pragma.plaza_comidas.application.handler.impl;

import com.pragma.factory.FactoryDishDataTest;
import com.pragma.plaza_comida.application.dto.request.DishRequestDto;
import com.pragma.plaza_comida.application.handler.impl.DishHandler;
import com.pragma.plaza_comida.application.mapper.request.IDishRequestMapper;
import com.pragma.plaza_comida.domain.api.IDishServicePort;
import com.pragma.plaza_comida.domain.model.DishModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class DishHandlerTest {
    @InjectMocks
    DishHandler dishHandler;
    @Mock
    IDishServicePort dishServicePort;
    @Mock
    IDishRequestMapper dishRequestMapper;

    @Test
    void mustSaveADish() {

        DishModel expectedDish = FactoryDishDataTest.getDishModle();

        DishRequestDto dishRequestDto = FactoryDishDataTest.getDishRequestDto();

        when(dishRequestMapper.toDish(any(DishRequestDto.class))).thenReturn(expectedDish);

        dishHandler.saveDish(dishRequestDto);

        verify(dishServicePort).saveDish(any(DishModel.class));
    }
}
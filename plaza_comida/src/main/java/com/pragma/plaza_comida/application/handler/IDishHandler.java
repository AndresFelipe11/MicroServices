package com.pragma.plaza_comida.application.handler;
import java.util.List;

import com.pragma.plaza_comida.application.dto.request.DishRequestDto;
import com.pragma.plaza_comida.application.dto.request.DishUpdateRequestDto;
import com.pragma.plaza_comida.application.dto.response.DishResponseDto;

public interface IDishHandler {

    void saveDish(DishRequestDto dishRequestDto);

    List<DishResponseDto> getAllDishes();

    DishResponseDto getDish(Long dishId);

    void updateDish(DishUpdateRequestDto dishUpdateRequestDto);

}

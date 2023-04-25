package com.pragma.plaza_comida.application.handler;


import java.util.List;

import com.pragma.plaza_comida.application.dto.request.CategoryRequestDto;
import com.pragma.plaza_comida.application.dto.response.CategoryResponseDto;

public interface ICategoryHandler {
    void saveCategory(CategoryRequestDto categoryRequestDto);

    List<CategoryResponseDto> getAllCategories();
}

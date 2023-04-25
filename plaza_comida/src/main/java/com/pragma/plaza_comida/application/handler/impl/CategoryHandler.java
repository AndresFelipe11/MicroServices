package com.pragma.plaza_comida.application.handler.impl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.pragma.plaza_comida.application.dto.request.CategoryRequestDto;
import com.pragma.plaza_comida.application.dto.response.CategoryResponseDto;
import com.pragma.plaza_comida.application.handler.ICategoryHandler;
import com.pragma.plaza_comida.application.mapper.request.ICategoryRequestMapper;
import com.pragma.plaza_comida.application.mapper.response.ICategoryResponseMapper;
import com.pragma.plaza_comida.domain.api.ICategoryServicePort;
import com.pragma.plaza_comida.domain.model.CategoryModel;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryHandler implements ICategoryHandler {

    private final ICategoryServicePort categoryServicePort;
    private final ICategoryRequestMapper categoryRequestMapper;
    private final ICategoryResponseMapper categoryResponseMapper;


    @Override
    public void saveCategory(CategoryRequestDto categoryRequestDto) {
        CategoryModel categoryModel = categoryRequestMapper.toCategory(categoryRequestDto);
        categoryServicePort.saveCategory(categoryModel);
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return categoryResponseMapper.toResponseList(categoryServicePort.getAllCategories());
    }
}

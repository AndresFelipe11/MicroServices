package com.pragma.plaza_comida.infrastructure.out.adapter;

import lombok.RequiredArgsConstructor;

import java.util.List;

import com.pragma.plaza_comida.domain.model.CategoryModel;
import com.pragma.plaza_comida.domain.spi.ICategoryPersistencePort;
import com.pragma.plaza_comida.infrastructure.exeption.CategoryNotFoundException;
import com.pragma.plaza_comida.infrastructure.exeption.NoDataFoundException;
import com.pragma.plaza_comida.infrastructure.out.entity.CategoryEntity;
import com.pragma.plaza_comida.infrastructure.out.mapper.ICategoryEntityMapper;
import com.pragma.plaza_comida.infrastructure.out.repository.ICategoryRepository;

@RequiredArgsConstructor
public class CategoryJpaAdapter implements ICategoryPersistencePort {

    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;


    @Override
    public CategoryModel saveCategory(CategoryModel categoryModel) {
        CategoryEntity categoryEntity = categoryRepository.save(categoryEntityMapper.toEntity(categoryModel));
        return categoryEntityMapper.toCategoryModel(categoryEntity);
    }

    @Override
    public CategoryModel getCategory(Long categoryId) {
        return categoryEntityMapper.toCategoryModel(categoryRepository.findById(categoryId).orElseThrow(CategoryNotFoundException::new));
    }

    @Override
    public List<CategoryModel> getAllCategories() {
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();

        if (categoryEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }

        return categoryEntityMapper.toCategoryModelList(categoryEntityList);
    }
}

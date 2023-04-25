package com.pragma.plaza_comida.domain.usecase;

import java.util.List;

import com.pragma.plaza_comida.domain.api.ICategoryServicePort;
import com.pragma.plaza_comida.domain.model.CategoryModel;
import com.pragma.plaza_comida.domain.spi.ICategoryPersistencePort;

public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public CategoryModel saveCategory(CategoryModel categoryModel) {
        categoryPersistencePort.saveCategory(categoryModel);
        return categoryModel;
    }

    @Override
    public CategoryModel getCategory(Long categoryId) {
        return categoryPersistencePort.getCategory(categoryId);
    }

    @Override
    public List<CategoryModel> getAllCategories() {
        return categoryPersistencePort.getAllCategories();
    }
}

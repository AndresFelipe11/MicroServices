package com.pragma.plaza_comida.domain.spi;

import java.util.List;

import com.pragma.plaza_comida.domain.model.CategoryModel;

public interface ICategoryPersistencePort {

    CategoryModel saveCategory(CategoryModel categoryModel);
    CategoryModel getCategory(Long categoryId);
    List<CategoryModel> getAllCategories();

}

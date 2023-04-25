package com.pragma.plaza_comida.domain.api;

import java.util.List;

import com.pragma.plaza_comida.domain.model.CategoryModel;

public interface ICategoryServicePort {
    CategoryModel saveCategory(CategoryModel categoryModel);

    CategoryModel getCategory(Long categoryId);

    List<CategoryModel> getAllCategories();

}

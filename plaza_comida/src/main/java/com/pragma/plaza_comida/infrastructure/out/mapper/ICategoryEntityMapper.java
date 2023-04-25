package com.pragma.plaza_comida.infrastructure.out.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.pragma.plaza_comida.domain.model.CategoryModel;
import com.pragma.plaza_comida.infrastructure.out.entity.CategoryEntity;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICategoryEntityMapper {

    CategoryEntity toEntity(CategoryModel categoryModel);

    CategoryModel toCategoryModel(CategoryEntity categoryEntity);

    List<CategoryModel> toCategoryModelList(List<CategoryEntity> categoryEntityList);

}

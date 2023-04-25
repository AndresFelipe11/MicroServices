

package com.pragma.plaza_comida.application.mapper.response;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.pragma.plaza_comida.application.dto.response.CategoryResponseDto;
import com.pragma.plaza_comida.domain.model.CategoryModel;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICategoryResponseMapper {
    CategoryResponseDto toResponse(CategoryModel categoryModel);

    List<CategoryResponseDto> toResponseList(List<CategoryModel> categoryModels);
}

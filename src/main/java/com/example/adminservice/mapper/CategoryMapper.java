package com.example.adminservice.mapper;

import com.example.adminservice.dto.CategoryDto;
import com.example.adminservice.entity.Category;
import com.example.adminservice.repository.CategoryRepository;
import org.hibernate.annotations.Target;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {


    @Mapping(target = "parent.id",source = "categoryDto.parentId")
    Category toEntity(CategoryDto categoryDto);

    CategoryDto toDto(Category category);

    List<CategoryDto> toDtoList(List<Category> categoryList);
}

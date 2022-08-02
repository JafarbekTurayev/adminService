package com.example.adminservice.mapper;

import com.example.adminservice.dto.CategoryDto;
import com.example.adminservice.dto.ProductDto;
import com.example.adminservice.entity.Category;
import com.example.adminservice.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "category.id",source = "productDto.categoryId")
    Product toEntity(ProductDto productDto);

}

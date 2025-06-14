package com.kidlitty.blogging_platform_api.mapper;

import com.kidlitty.blogging_platform_api.dto.CategoryDTO;
import com.kidlitty.blogging_platform_api.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "posts", ignore = true)
    Category toEntity(CategoryDTO categoryDTO);

    CategoryDTO toDto(Category category);
}

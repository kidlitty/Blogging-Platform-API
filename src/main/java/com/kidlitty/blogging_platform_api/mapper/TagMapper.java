package com.kidlitty.blogging_platform_api.mapper;

import com.kidlitty.blogging_platform_api.dto.TagDTO;
import com.kidlitty.blogging_platform_api.model.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TagMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "posts", ignore = true)
    Tag toEntity(TagDTO tagDTO);

    TagDTO toDto(Tag tag);
}

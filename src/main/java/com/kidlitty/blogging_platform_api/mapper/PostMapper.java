package com.kidlitty.blogging_platform_api.mapper;

import com.kidlitty.blogging_platform_api.dto.PostRequestDTO;
import com.kidlitty.blogging_platform_api.dto.PostResponseDTO;
import com.kidlitty.blogging_platform_api.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(target = "category", ignore = true)
    @Mapping(target = "tags", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Post toEntity(PostRequestDTO postRequestDTO);

    @Mapping(source = "user.username", target = "authorUsername")
    PostResponseDTO toDto(Post post);
}

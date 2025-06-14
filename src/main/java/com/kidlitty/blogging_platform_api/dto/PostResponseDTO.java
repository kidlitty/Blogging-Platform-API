package com.kidlitty.blogging_platform_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDTO {
    private Long id;
    private String title;
    private String content;
    private CategoryDTO category;
    private Set<TagDTO> tags;
    private String authorUsername;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}

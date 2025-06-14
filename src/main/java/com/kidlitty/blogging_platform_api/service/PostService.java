package com.kidlitty.blogging_platform_api.service;

import com.kidlitty.blogging_platform_api.dto.PostRequestDTO;
import com.kidlitty.blogging_platform_api.dto.PostResponseDTO;
import com.kidlitty.blogging_platform_api.mapper.PostMapper;
import com.kidlitty.blogging_platform_api.model.Category;
import com.kidlitty.blogging_platform_api.model.Post;
import com.kidlitty.blogging_platform_api.model.Tag;
import com.kidlitty.blogging_platform_api.model.User;
import com.kidlitty.blogging_platform_api.repository.UserRepository;
import com.kidlitty.blogging_platform_api.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final CategoryService categoryService;
    private final TagService tagService;
    private final UserRepository userRepository;

    @Autowired
    public PostService (PostRepository postRepository,
                        PostMapper postMapper,
                        CategoryService categoryService,
                        TagService tagService,
                        UserRepository userRepository) {
        this.postRepository = postRepository;
        this.categoryService = categoryService;
        this.tagService = tagService;
        this.postMapper = postMapper;
        this.userRepository = userRepository;
    }

    @Transactional
    public PostResponseDTO createPost(PostRequestDTO postRequestDTO) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User author = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("Authenticated user not found: " + username));

        Post post = postMapper.toEntity(postRequestDTO);

        Category category = categoryService.getCategoryEntityById(postRequestDTO.getCategoryId());
        post.setCategory(category);

        if (postRequestDTO.getTagIds() != null && !postRequestDTO.getTagIds().isEmpty()) {
            Set<Tag> tags = postRequestDTO.getTagIds().stream()
                    .map(tagId -> tagService.getTagEnityById(tagId))
                    .collect(Collectors.toSet());
            post.setTags(tags);
        }

        post.setUser(author);

        Post savedPost = postRepository.save(post);

        return postMapper.toDto(savedPost);
    }

    @Transactional(readOnly = true)
    public PostResponseDTO getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post not found with ID: " + id));
        return postMapper.toDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponseDTO> getAllPosts() {
        return postRepository.findAll().stream()
                .map(postMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public PostResponseDTO updatePost(Long id, PostRequestDTO postRequestDTO) {
        Post existingPost = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post not found with ID: " + id));

        existingPost.setTitle(postRequestDTO.getTitle());
        existingPost.setContent(postRequestDTO.getContent());

        if (postRequestDTO.getCategoryId() != null) {
            Category newCategory = categoryService.getCategoryEntityById(postRequestDTO.getCategoryId());
            existingPost.setCategory(newCategory);
        }

        if (postRequestDTO.getTagIds() != null) {
            Set<Tag> newTags = postRequestDTO.getTagIds().stream()
                    .map(tagId -> tagService.getTagEnityById(tagId))
                    .collect(Collectors.toSet());
            existingPost.setTags(newTags);
        } else {
            existingPost.setTags(new HashSet<>());
        }

        Post updatedPost = postRepository.save(existingPost);
        return postMapper.toDto(updatedPost);
    }

    @Transactional
    public void deletePost(Long id) {
        if (!postRepository.existsById(id)) {
            throw new EntityNotFoundException("Post not found with ID: " + id);
        }
        postRepository.deleteById(id);
    }
}

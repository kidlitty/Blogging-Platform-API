package com.kidlitty.blogging_platform_api.service;

import com.kidlitty.blogging_platform_api.dto.TagDTO;
import com.kidlitty.blogging_platform_api.exception.ResourceAlreadyExistsException;
import com.kidlitty.blogging_platform_api.mapper.TagMapper;
import com.kidlitty.blogging_platform_api.model.Tag;
import com.kidlitty.blogging_platform_api.repository.TagRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TagService {

    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    @Autowired
    public TagService(TagRepository tagRepository, TagMapper tagMapper) {
        this.tagRepository = tagRepository;
        this.tagMapper = tagMapper;
    }

    @Transactional
    public TagDTO createTag(TagDTO tagDTO) {

        Optional<Tag> existingTag = tagRepository.findByName(tagDTO.getName());
        if (existingTag.isPresent()) {
            throw new ResourceAlreadyExistsException("Tag with name '" + tagDTO.getName() + "' already exists.");
        }

        Tag tag = tagMapper.toEntity(tagDTO);
        Tag savedTag = tagRepository.save(tag);
        return tagMapper.toDto(savedTag);
    }

    @Transactional(readOnly = true)
    public TagDTO getTagById(Long id) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tag not found with ID: " + id));
        return tagMapper.toDto(tag);
    }

    @Transactional(readOnly = true)
    public List<TagDTO> getAllTags() {
        return tagRepository.findAll().stream()
                .map(tagMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public TagDTO updateTag (Long id, TagDTO tagDTO) {
        Tag existingTag = tagRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tag not found with ID: " + id));

        if (!existingTag.getName().equals(tagDTO.getName())) {
            if (tagRepository.findByName(tagDTO.getName()).isPresent()) {
                throw new ResourceAlreadyExistsException("Tag with name '" + tagDTO.getName() + "' already exists");
            }
        }

        existingTag.setName(tagDTO.getName());

        Tag updatedTag = tagRepository.save(existingTag);
        return tagMapper.toDto(updatedTag);
    }

    @Transactional
    public void deleteTag(Long id) {
        if (!tagRepository.existsById(id)) {
            throw new EntityNotFoundException("Tag not found with ID: " + id);
        }

        tagRepository.deleteById(id);
    }

    public Tag getTagEnityById(Long id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tag not found with ID: " + id));
    }
}

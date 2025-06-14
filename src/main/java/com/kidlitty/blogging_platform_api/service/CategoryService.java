package com.kidlitty.blogging_platform_api.service;

import com.kidlitty.blogging_platform_api.dto.CategoryDTO;
import com.kidlitty.blogging_platform_api.exception.ResourceAlreadyExistsException;
import com.kidlitty.blogging_platform_api.mapper.CategoryMapper;
import com.kidlitty.blogging_platform_api.model.Category;
import com.kidlitty.blogging_platform_api.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepostitory;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryService(CategoryRepository categoryRepostitory, CategoryMapper categoryMapper) {
        this.categoryRepostitory = categoryRepostitory;
        this.categoryMapper = categoryMapper;
    }

    @Transactional
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        if (categoryRepostitory.findByName(categoryDTO.getName()).isPresent()) {
            throw new ResourceAlreadyExistsException("Category with name '" + categoryDTO.getName() + "' already exists.");
        }
        Category category = categoryMapper.toEntity(categoryDTO);
        Category savedCategory = categoryRepostitory.save(category);
        return categoryMapper.toDto(savedCategory);
    }

    @Transactional(readOnly = true)
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepostitory.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with ID: " + id));
        return categoryMapper.toDto(category);
    }

    @Transactional(readOnly = true)
    public List<CategoryDTO> getAllCategories() {
        return categoryRepostitory.findAll().stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        Category existingCategory = categoryRepostitory.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with ID: " + id));

        if (!existingCategory.getName().equals(categoryDTO.getName()) &&
            categoryRepostitory.findByName(categoryDTO.getName()).isPresent()) {
            throw new ResourceAlreadyExistsException("Category with name '" + categoryDTO.getName() + "' already exists.");
        }

        existingCategory.setName(categoryDTO.getName());
        Category updatedCategory = categoryRepostitory.save(existingCategory);
        return categoryMapper.toDto(updatedCategory);
    }

    @Transactional
    public void deleteCategory(Long id) {
        if (!categoryRepostitory.existsById(id)) {
            throw new EntityNotFoundException("Category not found with ID: " + id);
        }

        categoryRepostitory.deleteById(id);
    }

    public Category getCategoryEntityById(Long id) {
        return categoryRepostitory.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with ID: " + id));
    }
}

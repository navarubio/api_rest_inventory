package com.sismacontab.inventory.controllers;

import com.sismacontab.inventory.models.Category;
import com.sismacontab.inventory.models.dto.CategoryDTO;
import com.sismacontab.inventory.repositories.CategoryRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryRepository repository;

    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Category> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Integer id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @GetMapping("/search")
    public List<Category> searchByName(@RequestParam String name) {
        return repository.findByCategoryNameContainingIgnoreCase(name);
    }

    @Cacheable(value = "categoryList")
    @GetMapping("/list")
    public List<CategoryDTO> getSimpleList() {
        return repository.findAll().stream()
            .map(category -> new CategoryDTO(category.getCategoryId(), category.getCategoryName()))
            .collect(Collectors.toList());
    }
}
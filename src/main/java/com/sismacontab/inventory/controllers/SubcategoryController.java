package com.sismacontab.inventory.controllers;

import com.sismacontab.inventory.models.Subcategory;
import com.sismacontab.inventory.models.dto.SubcategoryDTO;
import com.sismacontab.inventory.repositories.SubcategoryRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/subcategories")
public class SubcategoryController {
    private final SubcategoryRepository repository;

    public SubcategoryController(SubcategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Subcategory> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Subcategory getById(@PathVariable Integer id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Subcategory not found"));
    }

    @GetMapping("/category/{categoryId}")
    public List<Subcategory> getByCategoryId(@PathVariable Integer categoryId) {
        return repository.findByCategoryCategoryId(categoryId);
    }

    @GetMapping("/search")
    public List<Subcategory> searchByName(@RequestParam String name) {
        if (name == null || name.isEmpty()) {
            return repository.findAll();
        }
        return repository.findBySubcategoryNameContainingIgnoreCase(name);
    }

    @Cacheable(value = "subcategoryList")
    @GetMapping("/category/{categoryId}/list")
    public List<SubcategoryDTO> getSimpleListByCategory(@PathVariable Integer categoryId) {
        return repository.findByCategoryCategoryId(categoryId).stream()
            .map(sub -> new SubcategoryDTO(sub.getSubcategoryId(), sub.getSubcategoryName()))
            .collect(Collectors.toList());
    }
}
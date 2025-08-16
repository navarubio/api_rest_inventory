package com.sismacontab.inventory.controllers;

import com.sismacontab.inventory.models.Specific1;
import com.sismacontab.inventory.models.dto.Specific1DTO;
import com.sismacontab.inventory.repositories.Specific1Repository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/specific1")
public class Specific1Controller {
    private final Specific1Repository repository;

    public Specific1Controller(Specific1Repository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Specific1> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Specific1 getById(@PathVariable Integer id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Specific1 not found"));
    }

    // Original endpoint - maintained
    @GetMapping("/subcategory/{subcategoryId}")
    public List<Specific1> getBySubcategory(@PathVariable Integer subcategoryId) {
        return repository.findBySubcategory_SubcategoryId(subcategoryId);
    }

    // New optimized endpoint with cache
    @Cacheable(value = "specific1List")
    @GetMapping("/subcategory/{subcategoryId}/list")
    public List<Specific1DTO> getSimpleListBySubcategory(@PathVariable Integer subcategoryId) {
        return repository.findBySubcategory_SubcategoryId(subcategoryId).stream()
            .map(sp1 -> new Specific1DTO(sp1.getSpecific1Id(), sp1.getSpecific1Name()))
            .collect(Collectors.toList());
    }

    @GetMapping("/search")
    public List<Specific1> searchByName(@RequestParam String name) {
        if (name == null || name.isEmpty()) {
            return repository.findAll();
        }
        return repository.findBySpecific1NameContainingIgnoreCase(name);
    }
}
package com.sismacontab.inventory.controllers;

import com.sismacontab.inventory.models.Specific2;
import com.sismacontab.inventory.models.dto.Specific2DTO;
import com.sismacontab.inventory.repositories.Specific2Repository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/specific2")
public class Specific2Controller {
    private final Specific2Repository repository;

    public Specific2Controller(Specific2Repository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Specific2> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Specific2 getById(@PathVariable Integer id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Specific2 not found"));
    }

    // Original endpoint - maintained
    @GetMapping("/specific1/{specific1Id}")
    public List<Specific2> getBySpecific1(@PathVariable Integer specific1Id) {
        return repository.findBySpecific1_Specific1Id(specific1Id);
    }

    // New optimized endpoint with cache
    @Cacheable(value = "specific2List")
    @GetMapping("/specific1/{specific1Id}/list")
    public List<Specific2DTO> getSimpleListBySpecific1(@PathVariable Integer specific1Id) {
        return repository.findBySpecific1_Specific1Id(specific1Id).stream()
            .map(sp2 -> new Specific2DTO(sp2.getSpecific2Id(), sp2.getSpecific2Name()))
            .collect(Collectors.toList());
    }

    // Original hierarchy endpoint - maintained and cached
    @Cacheable(value = "hierarchyList")
    @GetMapping("/{id}/hierarchy")
    public Map<String, Object> getFullHierarchy(@PathVariable Integer id) {
        return repository.findFullHierarchyBySpecific2Id(id);
    }

    @GetMapping("/search")
    public List<Specific2> searchByName(@RequestParam String name) {
        if (name == null || name.isEmpty()) {
            return repository.findAll();
        }
        return repository.findBySpecific2NameContainingIgnoreCase(name);
    }
}
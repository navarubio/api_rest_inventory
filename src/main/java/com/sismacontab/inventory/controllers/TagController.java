package com.sismacontab.inventory.controllers;

import com.sismacontab.inventory.models.Tag;
import com.sismacontab.inventory.repositories.TagRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tags")
public class TagController {
    private final TagRepository repository;

    public TagController(TagRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Tag> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Tag getById(@PathVariable Integer id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tag no encontrado"));
    }

    @GetMapping("/activos")
    @Cacheable(value = "tagsActivos")
    public List<Tag> getActivos(@RequestParam(required = false) Integer limit) {
        List<Tag> tags = repository.findByActivoTrue();
        if (limit != null && limit > 0) {
            return tags.stream()
                      .limit(limit)
                      .collect(Collectors.toList());
        }
        return tags;
    }

    @GetMapping("/search")
    public List<Tag> searchByNombre(@RequestParam String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }

    @GetMapping("/producto/{codigoInterno}")
    public List<Tag> getByProducto(@PathVariable String codigoInterno) {
        return repository.findByProductoCodigoInterno(codigoInterno);
    }
}

package com.sismacontab.inventory.controllers;

import com.sismacontab.inventory.models.Tag;
import com.sismacontab.inventory.repositories.TagRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    @Cacheable("tagsActivos")
    public List<Tag> getActivos() {
        return repository.findByActivoTrue();
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

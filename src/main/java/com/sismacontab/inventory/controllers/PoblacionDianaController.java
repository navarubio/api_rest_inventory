package com.sismacontab.inventory.controllers;

import com.sismacontab.inventory.models.PoblacionDiana;
import com.sismacontab.inventory.repositories.PoblacionDianaRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/poblaciones-diana")
public class PoblacionDianaController {
    
    private final PoblacionDianaRepository repository;

    public PoblacionDianaController(PoblacionDianaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<PoblacionDiana> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public PoblacionDiana getById(@PathVariable Integer id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Población diana no encontrada"));
    }

    @GetMapping("/activas")
    @Cacheable("poblacionesDianaActivas")
    public List<PoblacionDiana> getActivas() {
        return repository.findByActivoTrue();
    }

    @GetMapping("/search")
    public List<PoblacionDiana> searchByNombre(@RequestParam String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }
}

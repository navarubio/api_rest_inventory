package com.sismacontab.inventory.controllers;

import com.sismacontab.inventory.models.FormaFarmaceutica;
import com.sismacontab.inventory.repositories.FormaFarmaceuticaRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/formas-farmaceuticas")
public class FormaFarmaceuticaController {
    
    private final FormaFarmaceuticaRepository repository;

    public FormaFarmaceuticaController(FormaFarmaceuticaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<FormaFarmaceutica> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public FormaFarmaceutica getById(@PathVariable Integer id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Forma farmacéutica no encontrada"));
    }

    @GetMapping("/activas")
    @Cacheable("formasFarmaceuticasActivas")
    public List<FormaFarmaceutica> getActivas() {
        return repository.findByActivoTrue();
    }

    @GetMapping("/search")
    public List<FormaFarmaceutica> searchByNombre(@RequestParam String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }
}

package com.sismacontab.inventory.controllers;

import com.sismacontab.inventory.models.ViaAdministracion;
import com.sismacontab.inventory.repositories.ViaAdministracionRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vias-administracion")
public class ViaAdministracionController {
    
    private final ViaAdministracionRepository repository;

    public ViaAdministracionController(ViaAdministracionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ViaAdministracion> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ViaAdministracion getById(@PathVariable Integer id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Vía de administración no encontrada"));
    }

    @GetMapping("/activas")
    @Cacheable("viasAdministracionActivas")
    public List<ViaAdministracion> getActivas() {
        return repository.findByActivoTrue();
    }

    @GetMapping("/search")
    public List<ViaAdministracion> searchByNombre(@RequestParam String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }
}

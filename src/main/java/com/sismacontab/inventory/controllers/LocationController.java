package com.sismacontab.inventory.controllers;

import com.sismacontab.inventory.models.Location;
import com.sismacontab.inventory.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventory")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    // Obtener todos los registros
    @GetMapping("/locations")
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    // Obtener un registro por ID
    @GetMapping("/locations/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable String id) {
        Optional<Location> location = locationRepository.findById(id);
        return location.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Obtener registros por campo local
    @GetMapping("/locations/local/{local}")
    public List<Location> getLocationsByLocal(@PathVariable String local) {
        return locationRepository.findByLocal(local);
    }

    // Obtener locales activos
    @GetMapping("/locations/active")
    public List<Location> getActiveLocations() {
        return locationRepository.findActiveLocations();
    }

    // Obtener locales que son call center
    @GetMapping("/locations/callcenter")
    public List<Location> getCallCenterLocations() {
        return locationRepository.findByIscallcenter("S");
    }
}
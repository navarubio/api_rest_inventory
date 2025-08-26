package com.sismacontab.inventory.controllers;

import com.sismacontab.inventory.dto.VademecumSuggestionDTO;
import com.sismacontab.inventory.repositories.ProductCategorizacionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vademecum-suggestions")
public class VademecumController {
    
    private final ProductCategorizacionRepository repository;

    public VademecumController(ProductCategorizacionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<VademecumSuggestionDTO> getSuggestion(@RequestParam String principioActivo) {
        return repository.findVademecumSuggestion(principioActivo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
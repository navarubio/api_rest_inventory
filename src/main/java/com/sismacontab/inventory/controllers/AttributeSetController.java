package com.sismacontab.inventory.controllers;

import com.sismacontab.inventory.models.AttributeSet;
import com.sismacontab.inventory.repositories.AttributeSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/laboratorio")
public class AttributeSetController {

    @Autowired
    private AttributeSetRepository attributeSetRepository;

    // Obtener todos los registros
    @GetMapping("/attributesets")
    public List<AttributeSet> getAllAttributeSets() {
        return attributeSetRepository.findAll();
    }

    // Obtener un registro por ID
    @GetMapping("/attributesets/{id}")
    public ResponseEntity<AttributeSet> getAttributeSetById(@PathVariable String id) {
        Optional<AttributeSet> attributeSet = attributeSetRepository.findById(id);
        return attributeSet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
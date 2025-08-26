package com.sismacontab.inventory.controllers;

import com.sismacontab.inventory.models.ProductoTag;
import com.sismacontab.inventory.models.dto.ProductoTagDTO;
import com.sismacontab.inventory.repositories.ProductoTagRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/producto-tags")
public class ProductoTagController {
    
    private final ProductoTagRepository repository;

    public ProductoTagController(ProductoTagRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/producto/{idProducto}")
    public List<ProductoTagDTO> getByProducto(@PathVariable String idProducto) {
        return repository.findDTOByIdProducto(idProducto);
    }
    @GetMapping("/tag/{idTag}")
    public List<ProductoTag> getByTag(@PathVariable Integer idTag) {
        return repository.findByIdTag(idTag);
    }

    @PostMapping("/producto/{idProducto}")
    public ResponseEntity<?> asignarTagsAProducto(
            @PathVariable String idProducto,
            @RequestBody List<Integer> tagIds) {
        
        // Primero eliminamos los tags existentes
        repository.deleteByIdProducto(idProducto);
        // Luego asignamos los nuevos tags
        List<ProductoTag> nuevosTags = tagIds.stream()
            .map(tagId -> {
                ProductoTag pt = new ProductoTag();
                pt.setIdProducto(idProducto);
                pt.setIdTag(tagId);
                return pt;
            })
            .collect(Collectors.toList());
        
        repository.saveAll(nuevosTags);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/buscar")
    public List<String> buscarProductosPorTags(@RequestParam List<Integer> tagIds) {
        return repository.findProductosWithAllTags(tagIds, tagIds.size());
    }

    @DeleteMapping("/producto/{idProducto}")
    public ResponseEntity<?> eliminarTagsDeProducto(@PathVariable String idProducto) {
        repository.deleteByIdProducto(idProducto);
        return ResponseEntity.ok().build();
    }
}

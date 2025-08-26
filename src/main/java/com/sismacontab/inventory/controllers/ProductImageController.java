package com.sismacontab.inventory.controllers;

import com.sismacontab.inventory.models.ProductImage;
import com.sismacontab.inventory.models.ProductImageWrite;
import com.sismacontab.inventory.models.dto.ProductImagesBulkUpdateDTO;
import com.sismacontab.inventory.models.dto.ProductImageUpdateDTO;
import com.sismacontab.inventory.repositories.ProductImageRepository;
import com.sismacontab.inventory.repositories.ProductImageWriteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/product-images")
public class ProductImageController {
    
    private final ProductImageRepository repository;
    private final ProductImageWriteRepository writeRepository;

    public ProductImageController(ProductImageRepository repository, ProductImageWriteRepository writeRepository) {
        this.repository = repository;
        this.writeRepository = writeRepository;
    }

    @GetMapping("/product/{codigoInterno}")
    public List<ProductImage> getProductImages(@PathVariable String codigoInterno) {
        return repository.findByCodigoInternoProductoOrderByOrdenAsc(codigoInterno);
    }

    @GetMapping("/product/{codigoInterno}/main")
    public ProductImage getMainProductImage(@PathVariable String codigoInterno) {
        return repository.findFirstByCodigoInternoProductoOrderByOrdenAsc(codigoInterno);
    }

    @GetMapping("/search")
    public List<ProductImage> searchByAltText(@RequestParam String altText) {
        return repository.findByAltTextContainingIgnoreCase(altText);
    }

    @GetMapping("/{id}")
    public ProductImage getById(@PathVariable Integer id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product image not found"));
    }

    @PostMapping("/products/{codigoInterno}/images/bulk-update")
    @Transactional
    public ResponseEntity<List<ProductImage>> bulkUpdateProductImages(
            @PathVariable String codigoInterno,
            @RequestBody ProductImagesBulkUpdateDTO bulkUpdateDTO) {
        
        // Primero, eliminamos todas las imágenes existentes del producto en la tabla de escritura
        writeRepository.deleteByCodigoInternoProducto(codigoInterno);
        
        // Creamos las nuevas imágenes para la tabla de escritura
        List<ProductImageWrite> writeImages = bulkUpdateDTO.getImages().stream()
            .map(dto -> createProductImageWriteFromDTO(codigoInterno, dto))
            .collect(Collectors.toList());
        
        // Guardamos todas las nuevas imágenes en la tabla de escritura
        writeRepository.saveAll(writeImages);
        
        // Retornamos las imágenes desde la tabla de lectura para confirmar
        List<ProductImage> savedImages = repository.findByCodigoInternoProductoOrderByOrdenAsc(codigoInterno);
        
        return ResponseEntity.ok(savedImages);
    }

    private ProductImageWrite createProductImageWriteFromDTO(String codigoInterno, ProductImageUpdateDTO dto) {
        return new ProductImageWrite(
            codigoInterno,
            dto.getRutaImagen(),
            dto.getOrden(),
            dto.getAltText()
        );
    }
}
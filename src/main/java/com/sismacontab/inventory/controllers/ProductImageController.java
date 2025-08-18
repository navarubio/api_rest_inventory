package com.sismacontab.inventory.controllers;

import com.sismacontab.inventory.models.ProductImage;
import com.sismacontab.inventory.repositories.ProductImageRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/product-images")
public class ProductImageController {
    
    private final ProductImageRepository repository;

    public ProductImageController(ProductImageRepository repository) {
        this.repository = repository;
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
}
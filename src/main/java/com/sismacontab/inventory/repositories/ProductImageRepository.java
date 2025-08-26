package com.sismacontab.inventory.repositories;

import com.sismacontab.inventory.models.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {
    
    // Find all images for a specific product
    List<ProductImage> findByCodigoInternoProductoOrderByOrdenAsc(String codigoInternoProducto);
    
    // Find main image (first in order) for a product
    ProductImage findFirstByCodigoInternoProductoOrderByOrdenAsc(String codigoInternoProducto);
    
    // Find images by alt text (useful for searching)
    List<ProductImage> findByAltTextContainingIgnoreCase(String altText);
    
    // Delete all images for a product
    void deleteByCodigoInternoProducto(String codigoInternoProducto);
}
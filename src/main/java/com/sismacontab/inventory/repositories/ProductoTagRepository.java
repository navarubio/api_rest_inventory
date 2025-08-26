package com.sismacontab.inventory.repositories;

import com.sismacontab.inventory.models.ProductoTag;
import com.sismacontab.inventory.models.ProductoTagId;
import com.sismacontab.inventory.models.dto.ProductoTagDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProductoTagRepository extends JpaRepository<ProductoTag, ProductoTagId> {
    
    // Encontrar todos los tags de un producto
    List<ProductoTag> findByIdProducto(String idProducto);
    
    // Query optimizada que retorna directamente la información necesaria
    @Query("SELECT NEW com.sismacontab.inventory.models.dto.ProductoTagDTO(pt.idProducto, pt.idTag, t.nombre) " +
           "FROM ProductoTag pt " +
           "JOIN Tag t ON pt.idTag = t.id " +
           "WHERE pt.idProducto = :idProducto")
    List<ProductoTagDTO> findDTOByIdProducto(@Param("idProducto") String idProducto);
    
    // Encontrar todos los productos que tienen un tag específico
    List<ProductoTag> findByIdTag(Integer idTag);
    
    // Buscar productos que tengan todos los tags especificados
    @Query(value = "SELECT pt.id_producto FROM fdw_vegfarm.producto_tags pt " +
           "WHERE pt.id_tag IN :tagIds " +
           "GROUP BY pt.id_producto " +
           "HAVING COUNT(DISTINCT pt.id_tag) = :tagCount", 
           nativeQuery = true)
    List<String> findProductosWithAllTags(@Param("tagIds") List<Integer> tagIds, @Param("tagCount") long tagCount);
    
    // Eliminar todos los tags de un producto
    void deleteByIdProducto(String idProducto);
}

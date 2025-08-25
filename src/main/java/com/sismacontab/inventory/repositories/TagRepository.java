package com.sismacontab.inventory.repositories;

import com.sismacontab.inventory.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Integer> {
    List<Tag> findByActivoTrue();
    List<Tag> findByNombreContainingIgnoreCase(String nombre);
    
    @Query(value = "SELECT t.* FROM fdw_vegfarm.maestro_tags t " +
           "INNER JOIN fdw_vegfarm.producto_tags pt ON t.id = pt.id_tag " +
           "WHERE pt.id_producto = :codigoInterno", nativeQuery = true)
    List<Tag> findByProductoCodigoInterno(@Param("codigoInterno") String codigoInterno);
}

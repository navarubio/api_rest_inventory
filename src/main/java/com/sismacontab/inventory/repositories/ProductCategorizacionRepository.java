package com.sismacontab.inventory.repositories;

import com.sismacontab.inventory.models.ProductCategorizacion;
import com.sismacontab.inventory.dto.VademecumSuggestionDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategorizacionRepository extends JpaRepository<ProductCategorizacion, String> {
    
    // Búsquedas por identificadores únicos
    ProductCategorizacion findByCodigoInterno(String codigoInterno);
    ProductCategorizacion findByUpc(String upc);
    
    // Búsquedas con paginación
    Page<ProductCategorizacion> findByNombreProductoContainingIgnoreCase(String nombre, Pageable pageable);
    Page<ProductCategorizacion> findByLaboratorioContainingIgnoreCase(String laboratorio, Pageable pageable);
    Page<ProductCategorizacion> findByCategoriaPrincipalContainingIgnoreCase(String categoriaPrincipal, Pageable pageable);
    Page<ProductCategorizacion> findBySubcategoria1ContainingIgnoreCase(String subcategoria1, Pageable pageable);
    Page<ProductCategorizacion> findBySubcategoria2ContainingIgnoreCase(String subcategoria2, Pageable pageable);
    Page<ProductCategorizacion> findBySubcategoria3ContainingIgnoreCase(String subcategoria3, Pageable pageable);
    Page<ProductCategorizacion> findByFormaFarmaceuticaContainingIgnoreCase(String formaFarmaceutica, Pageable pageable);
    Page<ProductCategorizacion> findByConcentracionDosisContainingIgnoreCase(String concentracionDosis, Pageable pageable);
    Page<ProductCategorizacion> findByContenidoEnvaseContainingIgnoreCase(String contenidoEnvase, Pageable pageable);
    Page<ProductCategorizacion> findByPoblacionDianaContainingIgnoreCase(String poblacionDiana, Pageable pageable);
    Page<ProductCategorizacion> findByPrincipioActivoContainingIgnoreCase(String principioActivo, Pageable pageable);
    Page<ProductCategorizacion> findByPatologiaContainingIgnoreCase(String patologia, Pageable pageable);
    Page<ProductCategorizacion> findByPosologiaContainingIgnoreCase(String posologia, Pageable pageable);
    Page<ProductCategorizacion> findByNivelCompletacion(Integer nivelCompletacion, Pageable pageable);

    @Query("SELECT p FROM ProductCategorizacion p " +
           "WHERE p.categoryId IS NOT NULL " +
           "AND p.subcategoryId IS NOT NULL " +
           "AND p.specific1Id IS NOT NULL " +
           "AND p.specific2Id IS NOT NULL")
    Page<ProductCategorizacion> findAllWithCompleteCategories(Pageable pageable);

    // Optional: búsqueda con filtro adicional por nombre
    @Query("SELECT p FROM ProductCategorizacion p " +
           "WHERE p.categoryId IS NOT NULL " +
           "AND p.subcategoryId IS NOT NULL " +
           "AND p.specific1Id IS NOT NULL " +
           "AND p.specific2Id IS NOT NULL " +
           "AND LOWER(p.nombreProducto) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    Page<ProductCategorizacion> findWithCompleteCategoriesByNombre(String nombre, Pageable pageable);

    @Query(value = 
    "SELECT " +
    "p.codigo_interno, p.upc, p.nombre_producto, p.presentacion_original, " +
    "p.laboratorio, p.categoria_original, " +
    "p.category_id, p.subcategory_id, p.specific_1_id, p.specific_2_id, " +
    "c.category_name as categoria_principal, " +  // Actualizamos los alias para que coincidan con el modelo
    "s.subcategory_name as subcategoria_1, " +
    "s1.specific_1_name as subcategoria_2, " +
    "s2.specific_2_name as subcategoria_3, " +
    "p.forma_farmaceutica, p.concentracion_dosis, p.contenido_envase, " +
    "p.via_administracion, p.poblacion_diana, p.tags_indicaciones, " +
    "p.pais_fabricacion, p.requiere_prescripcion_medica, p.es_psicotropico, " +
    "p.requiere_cadena_de_frio, p.principio_activo, p.patologia, " +
    "p.posologia, p.contraindicaciones, p.sustituto_sugerido, " +
    "p.nivel_completacion, p.fecha_creacion_registro, " +
    "p.fecha_ultima_modificacion, p.usuario_ultima_modificacion " +
    "FROM fdw_vegfarm.products_categorizacion p " +
    "INNER JOIN fdw_vegfarm.category c ON p.category_id = c.category_id " +
    "INNER JOIN fdw_vegfarm.subcategories s ON p.subcategory_id = s.subcategory_id " +
    "INNER JOIN fdw_vegfarm.specific_1 s1 ON p.specific_1_id = s1.specific_1_id " +
    "INNER JOIN fdw_vegfarm.specific_2 s2 ON p.specific_2_id = s2.specific_2_id " +
    "WHERE p.category_id IS NOT NULL " +
    "AND p.subcategory_id IS NOT NULL " +
    "AND p.specific_1_id IS NOT NULL " +
    "AND p.specific_2_id IS NOT NULL " +
    "AND (:nombre IS NULL OR LOWER(p.nombre_producto) LIKE LOWER(CONCAT('%', :nombre, '%'))) " +
    "AND (:categoriaPrincipal IS NULL OR LOWER(c.category_name) LIKE LOWER(CONCAT('%', :categoriaPrincipal, '%'))) " +
    "AND (:subcategoria1 IS NULL OR LOWER(s.subcategory_name) LIKE LOWER(CONCAT('%', :subcategoria1, '%'))) " +
    "AND (:subcategoria2 IS NULL OR LOWER(s1.specific_1_name) LIKE LOWER(CONCAT('%', :subcategoria2, '%'))) " +
    "AND (:subcategoria3 IS NULL OR LOWER(s2.specific_2_name) LIKE LOWER(CONCAT('%', :subcategoria3, '%')))", 
    countQuery = 
    "SELECT COUNT(*) " +
    "FROM fdw_vegfarm.products_categorizacion p " +
    "INNER JOIN fdw_vegfarm.category c ON p.category_id = c.category_id " +
    "INNER JOIN fdw_vegfarm.subcategories s ON p.subcategory_id = s.subcategory_id " +
    "INNER JOIN fdw_vegfarm.specific_1 s1 ON p.specific_1_id = s1.specific_1_id " +
    "INNER JOIN fdw_vegfarm.specific_2 s2 ON p.specific_2_id = s2.specific_2_id " +
    "WHERE p.category_id IS NOT NULL " +
    "AND p.subcategory_id IS NOT NULL " +
    "AND p.specific_1_id IS NOT NULL " +
    "AND p.specific_2_id IS NOT NULL " +
    "AND (:nombre IS NULL OR LOWER(p.nombre_producto) LIKE LOWER(CONCAT('%', :nombre, '%'))) " +
    "AND (:categoriaPrincipal IS NULL OR LOWER(c.category_name) LIKE LOWER(CONCAT('%', :categoriaPrincipal, '%'))) " +
    "AND (:subcategoria1 IS NULL OR LOWER(s.subcategory_name) LIKE LOWER(CONCAT('%', :subcategoria1, '%'))) " +
    "AND (:subcategoria2 IS NULL OR LOWER(s1.specific_1_name) LIKE LOWER(CONCAT('%', :subcategoria2, '%'))) " +
    "AND (:subcategoria3 IS NULL OR LOWER(s2.specific_2_name) LIKE LOWER(CONCAT('%', :subcategoria3, '%')))",
    nativeQuery = true)
    Page<ProductCategorizacion> findAllWithCompleteCategoriesAndFilters(
            @Param("nombre") String nombre,
            @Param("categoriaPrincipal") String categoriaPrincipal,
            @Param("subcategoria1") String subcategoria1,
            @Param("subcategoria2") String subcategoria2,
            @Param("subcategoria3") String subcategoria3,
            Pageable pageable);

    @Query(value = 
    "SELECT " +
    "principio_activo as principioActivo, " +
    "patologia as patologia, " +
    "posologia as posologia, " +
    "contraindicaciones as contraindicaciones, " +
    "sustituto_sugerido as sustitutoSugerido " +
    "FROM fdw_vegfarm.products_categorizacion " +
    "WHERE principio_activo ILIKE CONCAT('%', :principioActivo, '%') " +
    "AND posologia IS NOT NULL AND posologia <> '' " +
    "AND contraindicaciones IS NOT NULL AND contraindicaciones <> '' " +
    "LIMIT 1", nativeQuery = true)
    Optional<VademecumSuggestionDTO> findVademecumSuggestion(@Param("principioActivo") String principioActivo);
}
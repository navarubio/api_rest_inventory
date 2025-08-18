package com.sismacontab.inventory.repositories;

import com.sismacontab.inventory.models.ProductCategorizacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
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
}
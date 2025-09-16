package com.sismacontab.inventory.repositories;

import com.sismacontab.inventory.models.FacturaCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FacturaCompraRepository extends JpaRepository<FacturaCompra, Integer> {

    /**
     * Obtiene lista de proveedores con facturas de sustento '06' desde 2022
     * @return Lista de strings en formato 'id-nombre'
     */
    @Query(value = 
        "SELECT CONCAT(f.idproveedor, '-', f.razonsocial) as supplier " +
        "FROM opensri.facturacompra f " +
        "JOIN opensri.codigosustento c ON f.idcodigosustento = c.idcodigosustento " +
        "WHERE f.fechafactura >= '2022-01-01' " +
        "AND c.codigoats = '06' " +
        "GROUP BY f.idproveedor, f.razonsocial " +
        "ORDER BY f.razonsocial",
        nativeQuery = true)
    List<String> findSuppliersByCodigoSustento();

    /**
     * Obtiene facturas de un proveedor en un rango de fechas
     * @param fechaInicio Fecha de inicio
     * @param fechaFin Fecha de fin
     * @param proveedorId ID del proveedor
     * @return Lista de facturas
     */
    @Query(value = 
        "SELECT f.fechafactura, f.idproveedor, f.razonsocial, f.numerofactura, f.autorizacion " +
        "FROM opensri.facturacompra f " +
        "WHERE f.fechafactura BETWEEN :fechaInicio AND :fechaFin " +
        "AND f.idproveedor = :proveedorId " +
        "ORDER BY f.fechafactura DESC",
        nativeQuery = true)
    List<Object[]> findFacturasByProveedorAndDateRange(
            @Param("fechaInicio") LocalDate fechaInicio,
            @Param("fechaFin") LocalDate fechaFin,
            @Param("proveedorId") String proveedorId);
}
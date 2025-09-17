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
     * Obtiene lista única de proveedores con facturas de sustento '06' desde 2022
     * Utiliza CTE para eliminar duplicados causados por variaciones en el nombre
     * @return Lista de strings en formato 'id-nombre' (únicos y con nombres normalizados)
     */
    @Query(value = 
        "WITH RankedProveedores AS ( " +
        "    SELECT " +
        "        f.idproveedor, " +
        "        f.razonsocial, " +
        "        ROW_NUMBER() OVER(PARTITION BY f.idproveedor ORDER BY f.fechafactura DESC) as rn " +
        "    FROM " +
        "        opensri.facturacompra f " +
        "    JOIN " +
        "        opensri.codigosustento c ON f.idcodigosustento = c.idcodigosustento " +
        "    WHERE " +
        "        f.fechafactura >= '2022-01-01' " +
        "        AND c.codigoats = '06' " +
        ") " +
        "SELECT " +
        "    (idproveedor || '-' || INITCAP(TRIM(razonsocial))) AS supplier " +
        "FROM " +
        "    RankedProveedores " +
        "WHERE " +
        "    rn = 1 " +
        "ORDER BY " +
        "    razonsocial",
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

    /**
     * Obtiene todas las facturas con sustento '06' en un rango de fechas
     * @param fechaInicio Fecha de inicio
     * @param fechaFin Fecha de fin
     * @return Lista de facturas
     */
    @Query(value = 
        "SELECT f.fechafactura, f.idproveedor, f.razonsocial, f.numerofactura, f.autorizacion " +
        "FROM opensri.facturacompra f " +
        "JOIN opensri.codigosustento c ON f.idcodigosustento = c.idcodigosustento " +
        "WHERE f.fechafactura BETWEEN :fechaInicio AND :fechaFin " +
        "AND c.codigoats = '06' " +
        "ORDER BY f.fechafactura DESC",
        nativeQuery = true)
    List<Object[]> findFacturasBySustentoAndDateRange(
            @Param("fechaInicio") LocalDate fechaInicio,
            @Param("fechaFin") LocalDate fechaFin);

    /**
     * Obtiene facturas con código de sustento específico en un rango de fechas
     * @param codigoSustento Código de sustento
     * @param fechaInicio Fecha de inicio en formato string
     * @param fechaFin Fecha de fin en formato string
     * @return Lista de facturas
     */
    @Query(value = 
        "SELECT f.fechafactura, f.idproveedor, f.razonsocial, f.numerofactura, f.autorizacion " +
        "FROM opensri.facturacompra f " +
        "JOIN opensri.codigosustento c ON f.idcodigosustento = c.idcodigosustento " +
        "WHERE f.fechafactura BETWEEN CAST(:fechaInicio AS DATE) AND CAST(:fechaFin AS DATE) " +
        "AND c.codigoats = :codigoSustento " +
        "ORDER BY f.fechafactura DESC",
        nativeQuery = true)
    List<Object[]> findFacturasBySustentoAndDateRange(
            @Param("codigoSustento") String codigoSustento,
            @Param("fechaInicio") String fechaInicio,
            @Param("fechaFin") String fechaFin);

    /**
     * Obtiene facturas de un proveedor específico con código de sustento en un rango de fechas
     * @param codigoSustento Código de sustento
     * @param fechaInicio Fecha de inicio en formato string
     * @param fechaFin Fecha de fin en formato string
     * @param proveedorId ID del proveedor
     * @return Lista de facturas
     */
    @Query(value = 
        "SELECT f.fechafactura, f.idproveedor, f.razonsocial, f.numerofactura, f.autorizacion " +
        "FROM opensri.facturacompra f " +
        "JOIN opensri.codigosustento c ON f.idcodigosustento = c.idcodigosustento " +
        "WHERE f.fechafactura BETWEEN CAST(:fechaInicio AS DATE) AND CAST(:fechaFin AS DATE) " +
        "AND c.codigoats = :codigoSustento " +
        "AND f.idproveedor = :proveedorId " +
        "ORDER BY f.fechafactura DESC",
        nativeQuery = true)
    List<Object[]> findFacturasByProveedorAndDateRange(
            @Param("codigoSustento") String codigoSustento,
            @Param("fechaInicio") String fechaInicio,
            @Param("fechaFin") String fechaFin,
            @Param("proveedorId") String proveedorId);
}
package com.sismacontab.inventory.repositories;

import com.sismacontab.inventory.models.TicketBuyLines;
import com.sismacontab.inventory.models.TicketBuyLinesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketBuyLinesRepository extends JpaRepository<TicketBuyLines, TicketBuyLinesId> {

    /**
     * Obtiene productos de OpenBravo por RUC y componentes del número de factura
     * @param ruc RUC del proveedor
     * @param estab Establecimiento
     * @param emision Punto de emisión
     * @param secuencial Secuencial
     * @return Lista de productos desde OpenBravo con datos completos
     */
    @Query(value = 
        "SELECT " +
        "    ROW_NUMBER() OVER (ORDER BY tbl.line) AS \"ID\", " +
        "    (rb.estab || '-' || rb.emision || '-' || rb.secuencial) AS \"Numero_Factura\", " +
        "    CAST(rb.fecha AS DATE) AS \"Fecha_Factura\", " +
        "    prov.searchkey AS \"RUC\", " +
        "    prov.name AS \"Laboratorio\", " +
        "    p.id AS \"Code\", " +
        "    p.name AS \"Nombre\", " +
        "    tbl.lote AS \"Lote\", " +
        "    tbl.units AS \"Cantidad\", " +
        "    p.presentacion AS \"Presentacion\", " +
        "    tbl.registrosanitario AS \"Registro_Sanitario\", " +
        "    tbl.fechaelaboracion AS \"Fecha_Elaboracion\", " +
        "    tbl.fechavencimiento AS \"Fecha_Vencimiento\", " +
        "    tbl.pricebuy AS \"Precio\", " +
        "    tbl.ticket AS \"ticket\", " +
        "    tbl.line AS \"Line\" " +
        "FROM fdw_vegfarm.ticketbuylines AS tbl " +
        "JOIN fdw_vegfarm.products AS p ON tbl.product = p.id " +
        "LEFT JOIN fdw_vegfarm.lotes AS l ON tbl.idlote = l.idlote " +
        "JOIN fdw_vegfarm.RECEPCIONBUY AS rb ON tbl.ticket = rb.id " +
        "JOIN fdw_vegfarm.proveedor AS prov ON rb.rucproveedor = prov.id " +
        "WHERE prov.searchkey = :ruc " +
        "  AND rb.estab = :estab " +
        "  AND rb.emision = :emision " +
        "  AND rb.secuencial = :secuencial " +
        "ORDER BY tbl.line",
        nativeQuery = true)
    List<Object[]> findOpenBravoDetailsByRucAndFacturaComponents(
            @Param("ruc") String ruc,
            @Param("estab") String estab,
            @Param("emision") String emision,
            @Param("secuencial") String secuencial);
}
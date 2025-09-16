package com.sismacontab.inventory.repositories;

import com.sismacontab.inventory.models.TicketBuyLines;
import com.sismacontab.inventory.models.TicketBuyLinesId;
import com.sismacontab.inventory.models.dto.OpenBravoDetalleDTO;
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
     * @return Lista de productos desde OpenBravo
     */
    @Query(value = 
        "SELECT " +
        "ROW_NUMBER() OVER (ORDER BY tbl.line) AS id, " +
        "p.id AS code, " +
        "p.name AS nombre, " +
        "p.presentacion AS presentacion, " +
        "tbl.units AS cantidad, " +
        "tbl.pricebuy AS precio, " +
        "tbl.lote AS lote, " +
        "tbl.fechaelaboracion AS fecha_fabricacion, " +
        "tbl.fechavencimiento AS fecha_vencimiento, " +
        "tbl.registrosanitario AS registro_sanit " +
        "FROM fdw_vegfarm.ticketbuylines AS tbl " +
        "JOIN fdw_vegfarm.products AS p ON tbl.product = p.id " +
        "LEFT JOIN fdw_vegfarm.lotes AS l ON tbl.idlote = l.idlote " +
        "JOIN fdw_vegfarm.recepcionbuy AS rb ON tbl.ticket = rb.id " +
        "JOIN fdw_vegfarm.proveedor AS prov ON rb.rucproveedor = prov.id " +
        "WHERE prov.searchkey = :ruc " +
        "AND rb.estab = :estab " +
        "AND rb.emision = :emision " +
        "AND rb.secuencial = :secuencial " +
        "ORDER BY tbl.line",
        nativeQuery = true)
    List<Object[]> findOpenBravoDetailsByRucAndFacturaComponents(
            @Param("ruc") String ruc,
            @Param("estab") String estab,
            @Param("emision") String emision,
            @Param("secuencial") String secuencial);
}
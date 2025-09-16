package com.sismacontab.inventory.repositories;

import com.sismacontab.inventory.models.MasterLotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MasterLotesRepository extends JpaRepository<MasterLotes, Integer> {

    /**
     * Obtiene productos del XML por RUC y número de factura
     * @param ruc RUC del proveedor
     * @param numeroFactura Número de la factura
     * @return Lista de productos extraídos del XML
     */
    @Query("SELECT m FROM MasterLotes m WHERE m.ruc = :ruc AND m.numeroFactura = :numeroFactura")
    List<MasterLotes> findByRucAndNumeroFactura(
            @Param("ruc") String ruc,
            @Param("numeroFactura") String numeroFactura);
}
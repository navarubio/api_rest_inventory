package com.sismacontab.inventory.repositories;

import com.sismacontab.inventory.models.SateliteView;
import com.sismacontab.inventory.projections.CargaByEmpleadoProjection;
import com.sismacontab.inventory.projections.CargaByLocalProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SateliteViewRepository extends JpaRepository<SateliteView, String> {
    List<SateliteView> findByLocal(String local);
    List<SateliteView> findByNumerolote(String numerolote);
    List<SateliteView> findByProductName(String productName);

    @Query("SELECT s FROM SateliteView s WHERE s.fechavencimiento = :fechavencimiento")
    List<SateliteView> findByFechavencimientoExact(@Param("fechavencimiento") Date fechavencimiento);

    @Query("SELECT s FROM SateliteView s WHERE s.fechavencimiento <= :fechavencimiento")
    List<SateliteView> findByFechavencimientoBeforeOrEqual(@Param("fechavencimiento") Date fechavencimiento);

    @Query("SELECT s FROM SateliteView s WHERE s.product = :productId")
    List<SateliteView> findByProductId(@Param("productId") String productId);

    @Query("SELECT s FROM SateliteView s JOIN Product p ON s.product = p.id WHERE p.code = :code")
    List<SateliteView> findByProductCode(@Param("code") String code);

    @Query(value = "WITH user_records AS (" +
                   "    SELECT operador, COUNT(*) AS records_by_user" +
                   "    FROM fdw_vegfarm.satelite_view" +
                   "    GROUP BY operador" +
                   "), total_records AS (" +
                   "    SELECT SUM(records_by_user) AS total FROM user_records" +
                   ")" +
                   "SELECT ur.operador AS operador, ur.records_by_user AS recordsByUser, " +
                   "       ROUND((ur.records_by_user * 100.0) / tr.total, 2) AS porcentajeCarga, " +
                   "       ROUND((ur.records_by_user * 100.0) / tr.total, 0) AS puntuacion " +
                   "FROM user_records ur " +
                   "CROSS JOIN total_records tr " +
                   "ORDER BY ur.records_by_user DESC", nativeQuery = true)
    List<CargaByEmpleadoProjection> getCargaByEmpleado();

    @Query(value = "WITH local_records AS (" +
                   "    SELECT local || '-' || location_name AS localName, COUNT(*) AS recordsByLocal" +
                   "    FROM fdw_vegfarm.satelite_view" +
                   "    GROUP BY local, location_name" +
                   "), total_records AS (" +
                   "    SELECT SUM(recordsByLocal) AS total FROM local_records" +
                   ")" +
                   "SELECT lr.localName AS localName, lr.recordsByLocal AS recordsByLocal, " +
                   "       ROUND((lr.recordsByLocal * 100.0) / tr.total, 2) AS porcentajeCarga, " +
                   "       ROUND((lr.recordsByLocal * 100.0) / tr.total, 0) AS puntuacion " +
                   "FROM local_records lr " +
                   "CROSS JOIN total_records tr " +
                   "ORDER BY lr.recordsByLocal DESC", nativeQuery = true)
    List<CargaByLocalProjection> getCargaByLocal();

    // Nuevos métodos para buscar por laboratorio y locationName
    List<SateliteView> findByLaboratorio(String laboratorio);
    List<SateliteView> findByLocationName(String locationName);
}
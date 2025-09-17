package com.sismacontab.inventory.repositories;
import com.sismacontab.inventory.models.KardexEntry;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class KardexRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<KardexEntry> getKardexByProduct(String productId) {
        String sql = "SELECT * FROM opensri.get_kardex_by_product(:productId)";
        @SuppressWarnings("unchecked")
        List<Object[]> results = (List<Object[]>) entityManager.createNativeQuery(sql)
                .setParameter("productId", productId)
                .getResultList();

        List<KardexEntry> entries = new ArrayList<>();
        for (Object[] row : results) {
            KardexEntry entry = new KardexEntry();
            entry.fechaHora = (String) row[0];
            entry.codLocal = (String) row[1];
            entry.nombreLocation = (String) row[2];
            entry.laboratorio = (String) row[3];
            entry.idProduct = (String) row[4];
            entry.nombreProducto = (String) row[5];
            entry.presentacion = row[6] != null ? ((Number) row[6]).doubleValue() : null;
            entry.tipodocumento = (String) row[7];
            entry.documento = (String) row[8];
            entry.saldoAnterior = row[9] != null ? ((Number) row[9]).doubleValue() : null;
            entry.unidadesMovidas = row[10] != null ? ((Number) row[10]).doubleValue() : null;
            entry.saldoAcumulado = row[11] != null ? ((Number) row[11]).doubleValue() : null;
            entry.operador = (String) row[12];
            entry.costoPromedio = row[13] != null ? ((Number) row[13]).doubleValue() : null;
            entry.totalCosto = row[14] != null ? ((Number) row[14]).doubleValue() : null;
            entry.clienteProveedorOrigenDestino = (String) row[15];
            entries.add(entry);
        }
        return entries;
    }

    public List<KardexEntry> getKardexByProductPaged(
            String productId, String fechaDesde, String fechaHasta, String tipodocumento,
            String codLocal, String nombreLocation, int page, int size
    ) {
        StringBuilder sql = new StringBuilder("SELECT * FROM opensri.get_kardex_by_product(:productId) WHERE 1=1");
        if (fechaDesde != null && !fechaDesde.isEmpty()) {
            sql.append(" AND TO_TIMESTAMP(fecha_hora, 'DD/MM/YYYY HH24:MI') >= TO_TIMESTAMP(:fechaDesde, 'DD/MM/YYYY')");
        }
        if (fechaHasta != null && !fechaHasta.isEmpty()) {
            // Agregar 23:59:59 para incluir todo el día
            sql.append(" AND TO_TIMESTAMP(fecha_hora, 'DD/MM/YYYY HH24:MI') <= TO_TIMESTAMP(:fechaHasta || ' 23:59:59', 'DD/MM/YYYY HH24:MI:SS')");
        }
        if (tipodocumento != null && !tipodocumento.isEmpty()) {
            sql.append(" AND tipodocumento = :tipodocumento");
        }
        if (codLocal != null && !codLocal.isEmpty()) {
            sql.append(" AND cod_local = :codLocal");
        }
        if (nombreLocation != null && !nombreLocation.isEmpty()) {
            sql.append(" AND nombre_location ILIKE :nombreLocation");
        }
        // Ordenar por fecha_hora convertido a timestamp y luego por cod_local
        sql.append(" ORDER BY TO_TIMESTAMP(fecha_hora, 'DD/MM/YYYY HH24:MI') ASC, cod_local ASC");

        Query query = entityManager.createNativeQuery(sql.toString());
        query.setParameter("productId", productId);
        if (fechaDesde != null && !fechaDesde.isEmpty()) {
            query.setParameter("fechaDesde", fechaDesde);
        }
        if (fechaHasta != null && !fechaHasta.isEmpty()) {
            query.setParameter("fechaHasta", fechaHasta);
        }
        if (tipodocumento != null && !tipodocumento.isEmpty()) {
            query.setParameter("tipodocumento", tipodocumento);
        }
        if (codLocal != null && !codLocal.isEmpty()) {
            query.setParameter("codLocal", codLocal);
        }
        if (nombreLocation != null && !nombreLocation.isEmpty()) {
            query.setParameter("nombreLocation", "%" + nombreLocation + "%");
        }
        query.setFirstResult(page * size);
        query.setMaxResults(size);

        @SuppressWarnings("unchecked")
        List<Object[]> results = (List<Object[]>) query.getResultList();
        List<KardexEntry> entries = new ArrayList<>();
        for (Object[] row : results) {
            KardexEntry entry = new KardexEntry();
            entry.fechaHora = (String) row[0];
            entry.codLocal = (String) row[1];
            entry.nombreLocation = (String) row[2];
            entry.laboratorio = (String) row[3];
            entry.idProduct = (String) row[4];
            entry.nombreProducto = (String) row[5];
            entry.presentacion = row[6] != null ? ((Number) row[6]).doubleValue() : null;
            entry.tipodocumento = (String) row[7];
            entry.documento = (String) row[8];
            entry.saldoAnterior = row[9] != null ? ((Number) row[9]).doubleValue() : null;
            entry.unidadesMovidas = row[10] != null ? ((Number) row[10]).doubleValue() : null;
            entry.saldoAcumulado = row[11] != null ? ((Number) row[11]).doubleValue() : null;
            entry.operador = (String) row[12];
            entry.costoPromedio = row[13] != null ? ((Number) row[13]).doubleValue() : null;
            entry.totalCosto = row[14] != null ? ((Number) row[14]).doubleValue() : null;
            entry.clienteProveedorOrigenDestino = (String) row[15];
            entries.add(entry);
        }
        return entries;
    }

    public long countKardexByProduct(
            String productId, String fechaDesde, String fechaHasta, String tipodocumento,
            String codLocal, String nombreLocation
    ) {
        StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM opensri.get_kardex_by_product(:productId) WHERE 1=1");
        if (fechaDesde != null && !fechaDesde.isEmpty()) {
            sql.append(" AND TO_TIMESTAMP(fecha_hora, 'DD/MM/YYYY HH24:MI') >= TO_TIMESTAMP(:fechaDesde, 'DD/MM/YYYY')");
        }
        if (fechaHasta != null && !fechaHasta.isEmpty()) {
            // Agregar 23:59:59 para incluir todo el día
            sql.append(" AND TO_TIMESTAMP(fecha_hora, 'DD/MM/YYYY HH24:MI') <= TO_TIMESTAMP(:fechaHasta || ' 23:59:59', 'DD/MM/YYYY HH24:MI:SS')");
        }
        if (tipodocumento != null && !tipodocumento.isEmpty()) {
            sql.append(" AND tipodocumento = :tipodocumento");
        }
        if (codLocal != null && !codLocal.isEmpty()) {
            sql.append(" AND cod_local = :codLocal");
        }
        if (nombreLocation != null && !nombreLocation.isEmpty()) {
            sql.append(" AND nombre_location ILIKE :nombreLocation");
        }
        Query query = entityManager.createNativeQuery(sql.toString());
        query.setParameter("productId", productId);
        if (fechaDesde != null && !fechaDesde.isEmpty()) {
            query.setParameter("fechaDesde", fechaDesde);
        }
        if (fechaHasta != null && !fechaHasta.isEmpty()) {
            query.setParameter("fechaHasta", fechaHasta);
        }
        if (tipodocumento != null && !tipodocumento.isEmpty()) {
            query.setParameter("tipodocumento", tipodocumento);
        }
        if (codLocal != null && !codLocal.isEmpty()) {
            query.setParameter("codLocal", codLocal);
        }
        if (nombreLocation != null && !nombreLocation.isEmpty()) {
            query.setParameter("nombreLocation", "%" + nombreLocation + "%");
        }
        Object result = query.getSingleResult();
        return ((Number) result).longValue();
    }
}

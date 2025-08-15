package com.sismacontab.inventory.repositories;

import com.sismacontab.inventory.models.ProductByKardex;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductByKardexRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ProductByKardex> findAllPaged(String codigo, String descripcion, String laboratorio, int page, int size) {
        StringBuilder sql = new StringBuilder("SELECT * FROM fdw_vegfarm.products_by_kardex WHERE 1=1");
        if (codigo != null && !codigo.isEmpty()) {
            sql.append(" AND codigo ILIKE :codigo");
        }
        if (descripcion != null && !descripcion.isEmpty()) {
            sql.append(" AND descripcion_producto ILIKE :descripcion");
        }
        if (laboratorio != null && !laboratorio.isEmpty()) {
            sql.append(" AND laboratorio ILIKE :laboratorio");
        }
        sql.append(" ORDER BY descripcion_producto ASC"); // <-- Cambia aquí para ordenar por nombre
        Query query = entityManager.createNativeQuery(sql.toString());
        if (codigo != null && !codigo.isEmpty()) {
            query.setParameter("codigo", "%" + codigo + "%");
        }
        if (descripcion != null && !descripcion.isEmpty()) {
            query.setParameter("descripcion", "%" + descripcion + "%");
        }
        if (laboratorio != null && !laboratorio.isEmpty()) {
            query.setParameter("laboratorio", "%" + laboratorio + "%");
        }
        query.setFirstResult(page * size);
        query.setMaxResults(size);

        @SuppressWarnings("unchecked")
        List<Object[]> results = (List<Object[]>) query.getResultList();
        List<ProductByKardex> products = new ArrayList<>();
        for (Object[] row : results) {
            products.add(new ProductByKardex(
                (String) row[0],
                (String) row[1],
                (String) row[2],
                row[3] != null ? ((Number) row[3]).doubleValue() : null,
                (String) row[4],
                (String) row[5],
                (String) row[6],
                row[7] != null ? ((Number) row[7]).doubleValue() : null,
                row[8] != null ? ((Number) row[8]).doubleValue() : null,
                (String) row[9]
            ));
        }
        return products;
    }

    public long countAll(String codigo, String descripcion, String laboratorio) {
        StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM fdw_vegfarm.products_by_kardex WHERE 1=1");
        if (codigo != null && !codigo.isEmpty()) {
            sql.append(" AND codigo ILIKE :codigo");
        }
        if (descripcion != null && !descripcion.isEmpty()) {
            sql.append(" AND descripcion_producto ILIKE :descripcion");
        }
        if (laboratorio != null && !laboratorio.isEmpty()) {
            sql.append(" AND laboratorio ILIKE :laboratorio");
        }
        Query query = entityManager.createNativeQuery(sql.toString());
        if (codigo != null && !codigo.isEmpty()) {
            query.setParameter("codigo", "%" + codigo + "%");
        }
        if (descripcion != null && !descripcion.isEmpty()) {
            query.setParameter("descripcion", "%" + descripcion + "%");
        }
        if (laboratorio != null && !laboratorio.isEmpty()) {
            query.setParameter("laboratorio", "%" + laboratorio + "%");
        }
        Object result = query.getSingleResult();
        return ((Number) result).longValue();
    }

    public ProductByKardex findByCodigo(String codigo) {
        String sql = "SELECT * FROM fdw_vegfarm.products_by_kardex WHERE codigo = :codigo";
        @SuppressWarnings("unchecked")
        List<Object[]> results = (List<Object[]>) entityManager.createNativeQuery(sql)
                .setParameter("codigo", codigo)
                .getResultList();
        if (results.isEmpty()) return null;
        Object[] row = results.get(0);
        return new ProductByKardex(
            (String) row[0],
            (String) row[1],
            (String) row[2],
            row[3] != null ? ((Number) row[3]).doubleValue() : null,
            (String) row[4],
            (String) row[5],
            (String) row[6],
            row[7] != null ? ((Number) row[7]).doubleValue() : null,
            row[8] != null ? ((Number) row[8]).doubleValue() : null,
            (String) row[9]
        );
    }
}

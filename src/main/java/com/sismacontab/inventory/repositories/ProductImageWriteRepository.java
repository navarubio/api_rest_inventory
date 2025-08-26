package com.sismacontab.inventory.repositories;

import com.sismacontab.inventory.models.ProductImageWrite;
import com.sismacontab.inventory.models.ProductImageWriteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageWriteRepository extends JpaRepository<ProductImageWrite, ProductImageWriteId> {

    @Modifying
    @Query("DELETE FROM ProductImageWrite p WHERE p.codigoInternoProducto = :codigoInterno")
    void deleteByCodigoInternoProducto(@Param("codigoInterno") String codigoInterno);
}

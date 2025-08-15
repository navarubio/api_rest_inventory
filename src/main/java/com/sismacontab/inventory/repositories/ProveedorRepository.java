package com.sismacontab.inventory.repositories;

import com.sismacontab.inventory.models.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, String> {
    Optional<Proveedor> findByTaxid(String taxid);
}
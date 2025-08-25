package com.sismacontab.inventory.repositories;

import com.sismacontab.inventory.models.ViaAdministracion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ViaAdministracionRepository extends JpaRepository<ViaAdministracion, Integer> {
    List<ViaAdministracion> findByActivoTrue();
    List<ViaAdministracion> findByNombreContainingIgnoreCase(String nombre);
}

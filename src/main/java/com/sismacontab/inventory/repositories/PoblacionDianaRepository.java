package com.sismacontab.inventory.repositories;

import com.sismacontab.inventory.models.PoblacionDiana;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PoblacionDianaRepository extends JpaRepository<PoblacionDiana, Integer> {
    List<PoblacionDiana> findByActivoTrue();
    List<PoblacionDiana> findByNombreContainingIgnoreCase(String nombre);
}

package com.sismacontab.inventory.repositories;

import com.sismacontab.inventory.models.FormaFarmaceutica;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FormaFarmaceuticaRepository extends JpaRepository<FormaFarmaceutica, Integer> {
    List<FormaFarmaceutica> findByActivoTrue();
    List<FormaFarmaceutica> findByNombreContainingIgnoreCase(String nombre);
}

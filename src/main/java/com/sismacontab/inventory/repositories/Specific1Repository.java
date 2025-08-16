package com.sismacontab.inventory.repositories;

import com.sismacontab.inventory.models.Specific1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Specific1Repository extends JpaRepository<Specific1, Integer> {
    // Método para búsqueda por subcategoría
    List<Specific1> findBySubcategory_SubcategoryId(Integer subcategoryId);
    
    // Método para búsqueda por nombre
    List<Specific1> findBySpecific1NameContainingIgnoreCase(String name);
}
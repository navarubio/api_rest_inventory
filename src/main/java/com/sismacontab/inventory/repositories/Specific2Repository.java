package com.sismacontab.inventory.repositories;

import com.sismacontab.inventory.models.Specific2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface Specific2Repository extends JpaRepository<Specific2, Integer> {
    // Método para búsqueda por specific1
    List<Specific2> findBySpecific1_Specific1Id(Integer specific1Id);
    
    // Método para búsqueda por nombre
    List<Specific2> findBySpecific2NameContainingIgnoreCase(String name);
    
    // Query nativa para jerarquía completa
    @Query(value = "SELECT " +
           "c.category_id, c.category_name, " +
           "s.subcategory_id, s.subcategory_name, " +
           "s1.specific_1_id, s1.specific_1_name, " +
           "s2.specific_2_id, s2.specific_2_name " +
           "FROM fdw_vegfarm.category c " +
           "JOIN fdw_vegfarm.subcategories s ON c.category_id = s.category_id " +
           "JOIN fdw_vegfarm.specific_1 s1 ON s.subcategory_id = s1.subcategory_id " +
           "JOIN fdw_vegfarm.specific_2 s2 ON s1.specific_1_id = s2.specific_1_id " +
           "WHERE s2.specific_2_id = ?1", nativeQuery = true)
    Map<String, Object> findFullHierarchyBySpecific2Id(Integer specific2Id);
}
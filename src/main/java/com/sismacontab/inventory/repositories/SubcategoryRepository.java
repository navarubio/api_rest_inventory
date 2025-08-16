package com.sismacontab.inventory.repositories;

import com.sismacontab.inventory.models.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Integer> {
    List<Subcategory> findByCategoryCategoryId(Integer categoryId);
    List<Subcategory> findBySubcategoryNameContainingIgnoreCase(String name);
}
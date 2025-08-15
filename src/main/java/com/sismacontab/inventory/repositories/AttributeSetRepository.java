package com.sismacontab.inventory.repositories;

import com.sismacontab.inventory.models.AttributeSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeSetRepository extends JpaRepository<AttributeSet, String> {
}
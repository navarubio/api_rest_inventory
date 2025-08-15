package com.sismacontab.inventory.repositories;

import com.sismacontab.inventory.models.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<People, String> {
    Optional<People> findByName(String name);
    Optional<People> findByNameAndApppassword(String name, String apppassword);
}

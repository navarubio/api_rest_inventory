package com.sismacontab.inventory.repositories;

import com.sismacontab.inventory.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, String> {
    List<Location> findByLocal(String local);

    @Query("SELECT l FROM Location l WHERE l.address <> 'INIACTIVO'")
    List<Location> findActiveLocations();

    List<Location> findByIscallcenter(String iscallcenter);
}
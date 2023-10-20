package com.tsvetkov.testtask.repositories;

import com.tsvetkov.testtask.entities.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface HouseRepository extends JpaRepository<House, UUID> {
    House findHouseByUserId(UUID id);

    @Query(nativeQuery = true,
            value = "select exists(select * from house h where h.id_owner = :idPerson " +
                    "and h.id = :idHouse)")
    boolean personIsOwnerOfHouse(UUID idPerson, UUID idHouse);
}

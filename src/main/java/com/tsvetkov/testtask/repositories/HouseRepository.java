package com.tsvetkov.testtask.repositories;

import com.tsvetkov.testtask.entities.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HouseRepository extends JpaRepository<House, UUID> {
}

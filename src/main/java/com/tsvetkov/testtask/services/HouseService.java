package com.tsvetkov.testtask.services;

import com.tsvetkov.testtask.dto.HouseDto;
import com.tsvetkov.testtask.entities.House;
import com.tsvetkov.testtask.repositories.HouseRepository;
import jakarta.annotation.Nonnull;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HouseService {

    private final HouseRepository houseRepository;
    private final UserService userService;

    public House getHouseById(UUID id) {
        return houseRepository.getReferenceById(id);
    }

    public boolean isPersonOwner(@Nonnull UUID idPerson, @Nonnull UUID idHouse) {
        return houseRepository.personIsOwnerOfHouse(idPerson, idHouse);
    }

    public House getHouseByUserId(UUID id) {
        return houseRepository.findHouseByUserId(id);
    }

    @Transactional
    public void addOrUpdateHouse(HouseDto houseDto) {
        House house;
        UUID id = houseDto.getId();
        if (id != null) {
            house = houseRepository.getReferenceById(id);
        } else {
            house = new House();
        }
        house.setAddress(houseDto.getAddress());
        if (houseDto.getIdUser() != null) {
            house.setUser(userService.getUserById(houseDto.getIdUser()));
        }
        houseRepository.save(house);
    }

}

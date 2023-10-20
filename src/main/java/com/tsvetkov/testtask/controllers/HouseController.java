package com.tsvetkov.testtask.controllers;

import com.tsvetkov.testtask.dto.HouseDto;
import com.tsvetkov.testtask.entities.House;
import com.tsvetkov.testtask.services.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("house")
@RequiredArgsConstructor
public class HouseController {

    private final HouseService houseService;

    @PostMapping("addOrUpdate")
    public void addOrUpdateHouse(@RequestBody HouseDto houseDto) {
        houseService.addOrUpdateHouse(houseDto);
    }

    @GetMapping("isPersonOwnerOfHouse")
    public boolean isPersonOwnerOfHouse(@RequestParam(value = "idPerson") UUID idPerson,
                                        @RequestParam(value = "idHouse") UUID idHouse) {
        return houseService.isPersonOwner(idPerson, idHouse);
    }

    @GetMapping("getById")
    public House getHouseById(@RequestParam(value = "id") UUID id) {
        return houseService.getHouseById(id);
    }

}

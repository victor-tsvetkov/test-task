package com.tsvetkov.testtask.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class HouseDto {
    private UUID id;
    private String address;
    private UUID idUser;
}

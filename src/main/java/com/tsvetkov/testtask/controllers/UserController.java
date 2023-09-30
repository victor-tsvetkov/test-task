package com.tsvetkov.testtask.controllers;

import com.tsvetkov.testtask.dto.UserDto;
import com.tsvetkov.testtask.entities.User;
import com.tsvetkov.testtask.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("addOrUpdate")
    public void addOrUpdateUser(@RequestBody UserDto userDto) {
        userService.addOrUpdateUser(userDto);
    }

    @GetMapping("getById")
    public User getUserById(@RequestParam(value = "id") UUID id) {
        return userService.getUserById(id);
    }

}

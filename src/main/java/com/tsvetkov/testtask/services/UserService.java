package com.tsvetkov.testtask.services;

import com.tsvetkov.testtask.dto.UserDto;
import com.tsvetkov.testtask.entities.User;
import com.tsvetkov.testtask.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUserById(UUID id) {
        return userRepository.getReferenceById(id);
    }

    public void addOrUpdateUser(UserDto userDto) {
        User user;
        UUID id = userDto.getId();
        if (id != null) {
            user = userRepository.getReferenceById(id);
        } else {
            user = new User();
        }
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
    }

}

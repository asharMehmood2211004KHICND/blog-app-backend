package com.example.blogapp.services;

import com.example.blogapp.entities.User;
import com.example.blogapp.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);
    //UserDto updateUser(UserDto user);

    UserDto updateUser(UserDto user, Long userId);

    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    void deleteUser(Long userId);
}

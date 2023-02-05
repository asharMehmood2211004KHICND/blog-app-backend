package com.example.blogapp.services.impl;

import com.example.blogapp.entities.User;
import com.example.blogapp.exceptions.ResourceNotFoundException;
import com.example.blogapp.payloads.UserDto;
import com.example.blogapp.repositories.UserRepo;
import com.example.blogapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDto createUser(UserDto userDto) {
            User user = this.dtoToUser(userDto);
            User savedUser = userRepo.save(user);
            return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto user) {
        return null;
    }

//    @Override
//    public UserDto updateUser(UserDto userDto,Long userId) {
//
////        User user = this.userRepo.findById( userId)
////                .orElseThrow( ()
////                        ->
////                        new ResourceNotFoundException("User","id",userId));
//        return null;
//    }

    @Override
    public UserDto getUserById(UserDto user) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers(UserDto user) {
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {

    }

    private User dtoToUser(UserDto userDto){
        User user = new User();
        user.setId(user.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());
        return user;
    }

    private UserDto userToDto(User user){

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setAbout(user.getAbout());
        userDto.setPassword(user.getPassword());
        return userDto;
    }


}

package com.example.blogapp.controllers;

import com.example.blogapp.payloads.ApiResponse;
import com.example.blogapp.payloads.UserDto;
import com.example.blogapp.services.UserService;
import jakarta.validation.Valid;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //post-create-user
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createUserDto = userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    //put-update-user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser( @Valid @RequestBody UserDto userDto , @PathVariable("userId") Long uId ){
       UserDto updateUser = this.userService.updateUser(userDto,uId);
        return ResponseEntity.ok(updateUser);
    }

    //de
    // lete-delete-user
    @DeleteMapping("/{userId}")
    public  ResponseEntity<String> deleteUser(@PathVariable("userId") Long uid ){
        this.userService.deleteUser(uid);
//        return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted successflully",true));
        //return  new ResponseEntity<ApiResponse>(new ApiResponse("d",true));
//        String deleted = "deleted";
//        return ResponseEntity.ok(Map.of("as":"deleted"));
        //ResponseEntity responseEntity = new ResponseEntity(Map.of("s":"s"),HttpStatus.OK);
        //return responseEntity;
        return ResponseEntity.ok("deleted");
    }

    //get-get-user
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUser(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Long userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }
}

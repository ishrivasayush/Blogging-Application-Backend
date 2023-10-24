package com.narainox.blog.controller;

import com.narainox.blog.payloads.UserDto;
import com.narainox.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    //POST-Create user
    @PostMapping("/")
    public ResponseEntity<UserDto> createUserHandler(@RequestBody UserDto userDto)
    {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }
    //PUT-update user
//    @PutMapping("/")
//    public ResponseEntity<UserDto> createUserHandler(@RequestBody UserDto userDto)
//    {
//        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
//    }
    //DELETE-Delete user
    //POST-create user
}

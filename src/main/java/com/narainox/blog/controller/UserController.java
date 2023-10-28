package com.narainox.blog.controller;

import com.narainox.blog.payloads.ApiResponse;
import com.narainox.blog.payloads.UserDto;
import com.narainox.blog.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    //POST-Create user
    @PostMapping("/")
    public ResponseEntity<UserDto> createUserHandler(@Valid @RequestBody UserDto userDto)
    {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    // PUT- update user
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUserHandler(@Valid @RequestBody UserDto userDto ,@PathVariable("id") Integer id)
    {
        return new ResponseEntity<>(userService.updateUser(userDto,id), HttpStatus.OK);
    }

    //DELETE-Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<?>  deleteUserHandler(@PathVariable("id") Integer id)
    {
        userService.deleteUser(id);
        return new  ResponseEntity(new ApiResponse("User Deleted Successfully.",true),HttpStatus.OK);
    }

    //GET-get user by Id
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserByIdHandler(@PathVariable("id")Integer id)
    {
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.FOUND);
    }

    //GET all user
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getUserHandler()
    {
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.FOUND);
    }
}

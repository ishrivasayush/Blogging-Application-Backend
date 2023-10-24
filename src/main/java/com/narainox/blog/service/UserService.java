package com.narainox.blog.service;
import com.narainox.blog.payloads.UserDto;
import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto userDto,Integer userId);
    UserDto getUserById(Integer id);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);
}

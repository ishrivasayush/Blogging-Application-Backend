package com.narainox.blog.service.impl;

import com.narainox.blog.exception.ResourceNotFoundException;
import com.narainox.blog.model.User;
import com.narainox.blog.payloads.UserDto;
import com.narainox.blog.repository.UserRepo;
import com.narainox.blog.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user=dtoToUser(userDto);
        User saveUser = userRepo.save(user);
        return userToDto(saveUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user=userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User"," Id ", userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());
        User saveUser = userRepo.save(user);
        return userToDto(saveUser);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user=userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User"," Id ",userId));
        return userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users=userRepo.findAll();
        List<UserDto> userDtos= new ArrayList<>();
        for (User user:users)
        {
            UserDto userDto = userToDto(user);
            userDtos.add(userDto);
        }
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user=userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User"," Id ",userId));
        userRepo.delete(user);
    }

    private User dtoToUser(UserDto userDto)
    {
        User user=modelMapper.map(userDto,User.class);
        /*
        User user=new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

         */
        return user;
    }
    private UserDto userToDto(User user)
    {
        UserDto userDto=modelMapper.map(user,UserDto.class);

        /*        new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());
        */

        return userDto;
    }
}

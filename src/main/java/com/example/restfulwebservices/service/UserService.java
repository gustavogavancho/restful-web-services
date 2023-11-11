package com.example.restfulwebservices.service;

import com.example.restfulwebservices.model.User;
import com.example.restfulwebservices.service.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    UserDto findById(Integer id);
    UserDto add(UserDto user);
    void deleteById(Integer id);
}

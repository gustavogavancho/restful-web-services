package com.example.restfulwebservices.service;

import com.example.restfulwebservices.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Integer id);
    User add(User user);
    void deleteById(Integer id);
}

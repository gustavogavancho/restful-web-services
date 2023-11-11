package com.example.restfulwebservices.service.impl;

import com.example.restfulwebservices.exception.NotFoundException;
import com.example.restfulwebservices.model.User;
import com.example.restfulwebservices.repository.UserRepository;
import com.example.restfulwebservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(MessageFormat.format("User with id: {0} not found!", id)));
    }


    @Override
    public User add(User user) {
        userRepository.save(user);
        return  user;
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}

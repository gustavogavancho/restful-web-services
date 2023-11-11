package com.example.restfulwebservices.service.impl;

import com.example.restfulwebservices.exception.NotFoundException;
import com.example.restfulwebservices.model.User;
import com.example.restfulwebservices.repository.UserRepository;
import com.example.restfulwebservices.service.UserService;
import com.example.restfulwebservices.service.dto.UserDto;
import com.example.restfulwebservices.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::userToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Integer id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(MessageFormat.format("User with id: {0} not found!", id)));
        return userMapper.userToUserDTO(user);
    }


    @Override
    public UserDto add(UserDto userDto) {
        var user = userMapper.userDTOToUser(userDto);
        var savedUser = userRepository.save(user);
        return userMapper.userToUserDTO(savedUser);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}

package com.example.restfulwebservices.service.impl;

import com.example.restfulwebservices.exception.NotFoundException;
import com.example.restfulwebservices.model.User;
import com.example.restfulwebservices.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static List<User> users = new ArrayList();

    private static Integer usersCount = 0;

    static {
        users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll(){
        return users;
    }

    @Override
    public User findById(Integer id) {
        User userSearched = users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);

        if(userSearched == null) {
            throw  new NotFoundException("id: "+ id);
        }

        return userSearched;
    }

    @Override
    public User add(User user) {
        user.setId(++usersCount);
        users.add(user);

        return  user;
    }

    @Override
    public void deleteById(Integer id) {
        User userToDelete = users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);

        if(userToDelete == null) {
            throw  new NotFoundException("id: "+ id);
        }

        users.remove(userToDelete);
    }
}

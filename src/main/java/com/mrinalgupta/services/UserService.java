package com.mrinalgupta.services;

import com.mrinalgupta.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    List<User> list = new ArrayList<>();

    public UserService() {
        list.add(new User("abc", "abc", "ahjadja@gmail.com"));
        list.add(new User("xyz", "abcxyz", "xyz@gmail.com"));
    }

    public List<User> getAllUsers() {
        return this.list;
    }

    public Optional<User> getUser(String username) {
        return this.list
                .stream()
                .filter(user -> user.getUsername().equals(username))
                .findAny();
    }

    public User addUser(User user){
        this.list.add(user);
        return user;
    }
}

package com.mrinalgupta.controller;

import com.mrinalgupta.models.User;
import com.mrinalgupta.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PreAuthorize("hasRole('ADMIN')") // only ADMIn can invoke this method
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        boolean present=  userService.getUser(username).isPresent();
        if(present){
            return userService.getUser(username).get();
        }
        return null;
    }

    @PostMapping("/")
    public User addUser(@RequestBody(required = true) User user){
        return userService.addUser(user);
    }
}

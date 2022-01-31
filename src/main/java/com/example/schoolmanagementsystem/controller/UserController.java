package com.example.schoolmanagementsystem.controller;

import com.example.schoolmanagementsystem.dto.UserCreateDto;
import com.example.schoolmanagementsystem.entity.User;
import com.example.schoolmanagementsystem.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.POST)
    public User save(@RequestBody UserCreateDto dto) throws ClassNotFoundException {
        return userService.save(dto);
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public List<User> findAll(){
        return userService.findAll();
    }

    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long userId) throws ClassNotFoundException {
        return userService.findById(userId);
    }

    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.PUT)
    public User editUser(@PathVariable("id") Long userId, @RequestBody UserCreateDto dto) throws ClassNotFoundException {
        return userService.editUser(userId, dto);
    }

}

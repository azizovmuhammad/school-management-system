package com.example.schoolmanagementsystem.service;

import com.example.schoolmanagementsystem.dto.UserCreateDto;
import com.example.schoolmanagementsystem.entity.User;

import java.util.List;

public interface UserService {

    User save(UserCreateDto dto) throws ClassNotFoundException;

    List<User> findAll();

    User findById(Long userId) throws ClassNotFoundException;

    User editUser(Long userId, UserCreateDto dto) throws ClassNotFoundException;
}

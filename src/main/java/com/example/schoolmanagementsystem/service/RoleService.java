package com.example.schoolmanagementsystem.service;

import com.example.schoolmanagementsystem.dto.RoleDto;
import com.example.schoolmanagementsystem.entity.Role;

import java.util.List;

public interface RoleService {

    Role save(RoleDto dto);

    Role findById(Long id) throws ClassNotFoundException;

    List<Role> findAll() throws ClassNotFoundException;

    String deleteById(Long id) throws ClassNotFoundException;

    Role editById(Long id, RoleDto dto) throws ClassNotFoundException;
}

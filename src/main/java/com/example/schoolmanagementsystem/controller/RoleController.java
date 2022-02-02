package com.example.schoolmanagementsystem.controller;

import com.example.schoolmanagementsystem.dto.RoleDto;
import com.example.schoolmanagementsystem.entity.Role;
import com.example.schoolmanagementsystem.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/save")
    public Role save(@RequestBody RoleDto dto){
        return roleService.save(dto);
    }

    @GetMapping("/{id}")
    public Role findById(@PathVariable Long id) throws ClassNotFoundException {
        return roleService.findById(id);
    }

    @GetMapping("/all")
    public List<Role> findAll() throws ClassNotFoundException {
        return roleService.findAll();
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) throws ClassNotFoundException {
        return roleService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Role editById(@PathVariable Long id, @RequestBody RoleDto dto) throws ClassNotFoundException {
        return roleService.editById(id, dto);
    }
}

package com.example.schoolmanagementsystem.service.impl;

import com.example.schoolmanagementsystem.dto.RoleDto;
import com.example.schoolmanagementsystem.entity.Role;
import com.example.schoolmanagementsystem.repository.RoleRepository;
import com.example.schoolmanagementsystem.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public Role save(RoleDto dto) {
        Role role = new Role(
                dto.getName(),
                dto.getDescription()
        );
        return roleRepository.save(role);
    }

    @Override
    public Role findById(Long id) throws ClassNotFoundException {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isEmpty())
            throw new ClassNotFoundException("This Role Id Not Found");
        return optionalRole.get();
    }

    @Override
    public List<Role> findAll() throws ClassNotFoundException {
        List<Role> all = roleRepository.findAll();
        if (all.isEmpty())
            throw new ClassNotFoundException("Not Exists Role Yet");
        return all;
    }

    @Override
    public String deleteById(Long id) throws ClassNotFoundException {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isEmpty())
            throw new ClassNotFoundException("This Role Id Not Found");
        roleRepository.deleteById(id);

        return "Successfully Deleted";
    }

    @Override
    public Role editById(Long id, RoleDto dto) throws ClassNotFoundException {
        Optional<Role> optionalRole = roleRepository.findById(id);

        if (optionalRole.isEmpty())
            throw new ClassNotFoundException("This Role Id Not Found");
        Role role = optionalRole.get();

        if (!role.getName().equals(dto.getName()))
            role.setName(dto.getName());

        if (!role.getDescription().equals(dto.getDescription()))
            role.setDescription(dto.getDescription());

        return roleRepository.save(role);
    }
}

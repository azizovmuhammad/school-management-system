package com.example.schoolmanagementsystem.controller;

import com.example.schoolmanagementsystem.dto.ClassesDto;
import com.example.schoolmanagementsystem.entity.Classes;
import com.example.schoolmanagementsystem.service.ClassService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/classes")
public class ClassesController {

    private final ClassService classService;

    public ClassesController(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping
    public Classes save(@RequestBody ClassesDto dto) throws ClassNotFoundException {
        return classService.save(dto);
    }
}

package com.example.schoolmanagementsystem.controller;

import com.example.schoolmanagementsystem.dto.ClassesDto;
import com.example.schoolmanagementsystem.entity.Classes;
import com.example.schoolmanagementsystem.service.ClassService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClassesController {

    private final ClassService classService;

    public ClassesController(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping("/save")
    public Classes save(@RequestBody ClassesDto dto) throws ClassNotFoundException {
        return classService.save(dto);
    }

    @GetMapping("/{id}")
    public Classes findById(@PathVariable Long id) throws ClassNotFoundException {
        return classService.findById(id);
    }

    @GetMapping("/all")
    public List<Classes> findAll(){
        return classService.findAll();
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        return classService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Classes editById(@PathVariable Long id, ClassesDto dto ) throws ClassNotFoundException {
        return classService.editById(id, dto);
    }
}

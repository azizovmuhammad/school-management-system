package com.example.schoolmanagementsystem.controller;

import com.example.schoolmanagementsystem.dto.SchoolDto;
import com.example.schoolmanagementsystem.entity.School;
import com.example.schoolmanagementsystem.service.SchoolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    private final SchoolService schoolService;


    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/save")
    public School save(@RequestBody SchoolDto dto) throws ClassNotFoundException {
        return schoolService.save(dto);
    }

    @GetMapping("/{id}")
    public School findById(@PathVariable Long id) throws ClassNotFoundException {
        return schoolService.findById(id);
    }

    @GetMapping("/all")
    public List<School> findAll(){
        return schoolService.findAll();
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) throws ClassNotFoundException {
        return schoolService.deleteById(id);
    }

    @PutMapping("/{id}")
    public School editById(@PathVariable Long id, @RequestBody SchoolDto dto) throws ClassNotFoundException {
        return schoolService.editById(id,dto);
    }
}

package com.example.schoolmanagementsystem.controller;

import com.example.schoolmanagementsystem.dto.SubjectDto;
import com.example.schoolmanagementsystem.entity.Subject;
import com.example.schoolmanagementsystem.service.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/save")
    public Subject save(@RequestBody SubjectDto dto) throws ClassNotFoundException {
        return subjectService.save(dto);
    }

    @GetMapping("/{id}")
    public Subject findById(@PathVariable Long id) throws ClassNotFoundException {
        return subjectService.findById(id);
    }

    @GetMapping("/all")
    public List<Subject> findAll(){
        return subjectService.findAll();
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) throws ClassNotFoundException {
        return subjectService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Subject editById(@PathVariable Long id, @RequestBody SubjectDto dto) throws ClassNotFoundException {
        return subjectService.editById(id,dto);
    }
}

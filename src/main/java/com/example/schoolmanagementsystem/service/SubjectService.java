package com.example.schoolmanagementsystem.service;

import com.example.schoolmanagementsystem.dto.SubjectDto;
import com.example.schoolmanagementsystem.entity.Subject;

import java.util.List;

public interface SubjectService {

    Subject save(SubjectDto dto);

    Subject findById(Long id) throws ClassNotFoundException;

    List<Subject> findAll();

    String deleteById(Long id) throws ClassNotFoundException;

    Subject editById(Long id, SubjectDto dto) throws ClassNotFoundException;
}

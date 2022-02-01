package com.example.schoolmanagementsystem.service;

import com.example.schoolmanagementsystem.dto.ClassesDto;
import com.example.schoolmanagementsystem.entity.Classes;

import java.util.List;


public interface ClassService {

    Classes save(ClassesDto dto) throws ClassNotFoundException;

    Classes findById(Long id) throws ClassNotFoundException;

    List<Classes> findAll();

    String deleteById(Long id);

    Classes editById(Long id, ClassesDto dto) throws ClassNotFoundException;
}

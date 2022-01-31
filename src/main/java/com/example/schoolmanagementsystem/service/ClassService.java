package com.example.schoolmanagementsystem.service;

import com.example.schoolmanagementsystem.dto.ClassesDto;
import com.example.schoolmanagementsystem.entity.Classes;


public interface ClassService {
    Classes save(ClassesDto dto) throws ClassNotFoundException;
}

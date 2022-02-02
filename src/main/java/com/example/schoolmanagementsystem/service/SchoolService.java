package com.example.schoolmanagementsystem.service;

import com.example.schoolmanagementsystem.dto.SchoolDto;
import com.example.schoolmanagementsystem.entity.School;

import java.util.List;

public interface SchoolService {

    School save(SchoolDto dto) throws ClassNotFoundException;

    School findById(Long id) throws ClassNotFoundException;

    List<School> findAll();

    String deleteById(Long id) throws ClassNotFoundException;

    School editById(Long id, SchoolDto dto) throws ClassNotFoundException;
}

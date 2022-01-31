package com.example.schoolmanagementsystem.repository;

import com.example.schoolmanagementsystem.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}

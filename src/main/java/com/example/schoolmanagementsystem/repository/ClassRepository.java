package com.example.schoolmanagementsystem.repository;

import com.example.schoolmanagementsystem.entity.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Classes, Long> {
}

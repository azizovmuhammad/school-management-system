package com.example.schoolmanagementsystem.repository;

import com.example.schoolmanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

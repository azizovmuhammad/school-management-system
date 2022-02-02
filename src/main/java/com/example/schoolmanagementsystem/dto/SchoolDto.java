package com.example.schoolmanagementsystem.dto;

import com.example.schoolmanagementsystem.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDto {

    private String name;
    private Long addressId;
}

package com.example.schoolmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {

    private String name;
    private String email;
    private Long roleId;
    private Long addressId;
    private Long schoolId;


}

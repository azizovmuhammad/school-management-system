package com.example.schoolmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassesDto {

    private String name;
    private Integer maxStudent;
    private Long subjectId;
    private Long teacherId;
    private Set<Long> studentIds;

}

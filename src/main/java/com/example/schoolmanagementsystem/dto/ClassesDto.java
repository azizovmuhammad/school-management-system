package com.example.schoolmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassesDto {

    private Long id;
    private String name;
    private Integer maxStudent;
    private Long subjectId;
    private Long teacherId;
    private Set<Long> studentIds;

    public ClassesDto(String name, Integer maxStudent, Long subjectId, Long teacherId, Set<Long> studentIds) {
        this.name = name;
        this.maxStudent = maxStudent;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
        this.studentIds = studentIds;
    }
}

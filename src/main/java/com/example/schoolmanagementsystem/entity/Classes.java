package com.example.schoolmanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "classes")
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer maxStudent;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private User teacher;

    @OneToMany
    private List<User> studentList;

    public Classes(String name, Integer maxStudent, Subject subject, User teacher) {
        this.name = name;
        this.maxStudent = maxStudent;
        this.subject = subject;
        this.teacher = teacher;

    }
}

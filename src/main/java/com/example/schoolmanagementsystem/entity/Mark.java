package com.example.schoolmanagementsystem.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "marks")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 50, max = 100)
    private Integer score;

    private LocalDateTime givenDateTime;

    @ManyToOne
    private User student;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Classes classes;

}

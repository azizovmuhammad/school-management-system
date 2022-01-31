package com.example.schoolmanagementsystem.service.impl;

import com.example.schoolmanagementsystem.dto.ClassesDto;
import com.example.schoolmanagementsystem.entity.Classes;
import com.example.schoolmanagementsystem.entity.Subject;
import com.example.schoolmanagementsystem.entity.User;
import com.example.schoolmanagementsystem.repository.ClassRepository;
import com.example.schoolmanagementsystem.repository.SubjectRepository;
import com.example.schoolmanagementsystem.repository.UserRepository;
import com.example.schoolmanagementsystem.service.ClassService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ClassServiceImpl implements ClassService {

   private final ClassRepository classRepository;
   private final SubjectRepository subjectRepository;
   private final UserRepository userRepository;

    public ClassServiceImpl(ClassRepository classRepository, SubjectRepository subjectRepository, UserRepository userRepository) {
        this.classRepository = classRepository;
        this.subjectRepository = subjectRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Classes save(ClassesDto dto) throws ClassNotFoundException {

        Optional<Subject> subjectOptional = subjectRepository.findById(dto.getSubjectId());
        if (subjectOptional.isEmpty())
            throw new ClassNotFoundException("Subject Not Found");
        Subject subject = subjectOptional.get();

        Optional<User> teacherOptional = userRepository.findById(dto.getTeacherId());
        if (teacherOptional.isEmpty())
            throw new ClassNotFoundException("Teacher Not Found");
        User teacher = teacherOptional.get();

        Classes classes = new Classes(
                dto.getName(),
                dto.getMaxStudent(),
                subject,
                teacher
        );

        Set<Long> studentIds = dto.getStudentIds();
        List<User> userList = new ArrayList<>();

        for (Long studentId : studentIds) {
            Optional<User> byId = userRepository.findById(studentId);
            byId.ifPresent(userList::add);
        }

        classes.setStudentList(userList);
        return classRepository.save(classes);
    }
}

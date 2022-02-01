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

    @Override
    public Classes findById(Long id) throws ClassNotFoundException {
        Optional<Classes> byId = classRepository.findById(id);
        if (byId.isEmpty())
            throw new ClassNotFoundException("This Class Id Not Found");
        return byId.get();
    }

    @Override
    public List<Classes> findAll() {
        return classRepository.findAll();
    }

    @Override
    public String deleteById(Long id) {
        classRepository.deleteById(id);
        return "Successfully Deleted";
    }

    @Override
    public Classes editById(Long id, ClassesDto dto) throws ClassNotFoundException {
        Optional<Classes> optionalClasses = classRepository.findById(id);
        if (optionalClasses.isEmpty())
            throw new ClassNotFoundException("Such Class Id Not Found");
        Classes classes = optionalClasses.get();

        Optional<Subject> optionalSubject = subjectRepository.findById(dto.getSubjectId());
        if (optionalSubject.isEmpty())
            throw new ClassNotFoundException("Such Subject Id Not Found");
        Subject subject = optionalSubject.get();

        Optional<User> optionalTeacher = userRepository.findById(dto.getTeacherId());
        if (optionalTeacher.isEmpty())
            throw new ClassNotFoundException("Such Teacher Id Not Found");
        User teacher = optionalTeacher.get();

        if (!(classes.getName().equals(dto.getName()))){
            classes.setName(dto.getName());
        }

        if (!(classes.getMaxStudent().equals(dto.getMaxStudent()))) {
            classes.setMaxStudent(dto.getMaxStudent());
        }

        if (!(classes.getSubject().getId().equals(dto.getSubjectId()))) {
            classes.setSubject(subject);
        }

        if (!(classes.getTeacher().getId().equals(dto.getTeacherId()))){
            classes.setTeacher(teacher);
        }

        return null;
    }

}

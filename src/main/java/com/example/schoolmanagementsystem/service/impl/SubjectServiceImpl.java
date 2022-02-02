package com.example.schoolmanagementsystem.service.impl;

import com.example.schoolmanagementsystem.dto.SubjectDto;
import com.example.schoolmanagementsystem.entity.Subject;
import com.example.schoolmanagementsystem.repository.SubjectRepository;
import com.example.schoolmanagementsystem.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject save(SubjectDto dto) {
        Subject subject = new Subject(
                dto.getName(),
                dto.getDescription()
        );
        return subjectRepository.save(subject);
    }

    @Override
    public Subject findById(Long id) throws ClassNotFoundException {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if (optionalSubject.isEmpty())
            throw new ClassNotFoundException("This Subject Id Not Found");
        return optionalSubject.get();
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public String deleteById(Long id) throws ClassNotFoundException {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if (optionalSubject.isEmpty())
            throw new ClassNotFoundException("This Subject Id Not Found");
        subjectRepository.deleteById(id);
        return "Successfully Deleted";
    }

    @Override
    public Subject editById(Long id, SubjectDto dto) throws ClassNotFoundException {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if (optionalSubject.isEmpty())
            throw new ClassNotFoundException("This Subject Id Not Found");

        Subject subject = optionalSubject.get();
        if (!subject.getName().equals(dto.getName()))
            subject.setName(dto.getName());

        if (!subject.getDescription().equals(dto.getDescription()))
            subject.setDescription(dto.getDescription());

        return subjectRepository.save(subject);
    }
}

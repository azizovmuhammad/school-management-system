package com.example.schoolmanagementsystem.service.impl;

import com.example.schoolmanagementsystem.dto.SchoolDto;
import com.example.schoolmanagementsystem.entity.Address;
import com.example.schoolmanagementsystem.entity.School;
import com.example.schoolmanagementsystem.repository.AddressRepository;
import com.example.schoolmanagementsystem.repository.SchoolRepository;
import com.example.schoolmanagementsystem.service.SchoolService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceImpl implements SchoolService {
    private final AddressRepository addressRepository;
    private final SchoolRepository schoolRepository;

    public SchoolServiceImpl(AddressRepository addressRepository, SchoolRepository schoolRepository) {
        this.addressRepository = addressRepository;
        this.schoolRepository = schoolRepository;
    }

    @Override
    public School save(SchoolDto dto) throws ClassNotFoundException {
        Optional<Address> optionalAddress = addressRepository.findById(dto.getAddressId());
        if (optionalAddress.isEmpty())
            throw new ClassNotFoundException("This School Id Not Found");
        Address address = optionalAddress.get();

        School school = new School(
                dto.getName(),
                address
        );

        return schoolRepository.save(school);
    }

    @Override
    public School findById(Long id) throws ClassNotFoundException {
        Optional<School> optionalSchool = schoolRepository.findById(id);
        if (optionalSchool.isEmpty())
            throw new ClassNotFoundException("This School Id Not Found");

        return optionalSchool.get();
    }

    @Override
    public List<School> findAll() {
        return schoolRepository.findAll();
    }

    @Override
    public String deleteById(Long id) throws ClassNotFoundException {
        Optional<School> optionalSchool = schoolRepository.findById(id);
        if (optionalSchool.isEmpty())
            throw new ClassNotFoundException("This School Id Not Found");
        schoolRepository.deleteById(id);
        return "Successfully Deleted";
    }

    @Override
    public School editById(Long id, SchoolDto dto) throws ClassNotFoundException {
        Optional<School> optionalSchool = schoolRepository.findById(id);
        if (optionalSchool.isEmpty())
            throw new ClassNotFoundException("This School Id Not Found ");
        Optional<Address> optionalAddress = addressRepository.findById(dto.getAddressId());
        if (optionalAddress.isEmpty())
            throw new ClassNotFoundException("This Address Id Not Found");
        School school = optionalSchool.get();

        if (!school.getName().equals(dto.getName()))
            school.setName(dto.getName());

        return schoolRepository.save(school);
    }
}

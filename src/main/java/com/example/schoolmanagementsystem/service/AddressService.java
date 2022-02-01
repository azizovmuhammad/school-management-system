package com.example.schoolmanagementsystem.service;

import com.example.schoolmanagementsystem.dto.AddressDto;
import com.example.schoolmanagementsystem.entity.Address;

import java.util.List;

public interface AddressService {

    Address save(AddressDto dto);

    Address findById(Long id) throws ClassNotFoundException;

    List<Address> findAll();

    String deleteById(Long id);

    Address editById(Long id, AddressDto dto) throws ClassNotFoundException;
}

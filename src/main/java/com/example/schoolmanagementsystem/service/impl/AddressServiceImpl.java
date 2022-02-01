package com.example.schoolmanagementsystem.service.impl;

import com.example.schoolmanagementsystem.dto.AddressDto;
import com.example.schoolmanagementsystem.entity.Address;
import com.example.schoolmanagementsystem.repository.AddressRepository;
import com.example.schoolmanagementsystem.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address save(AddressDto dto) {
        Address address = new Address(
                dto.getName());

        return addressRepository.save(address);
    }

    @Override
    public Address findById(Long id) throws ClassNotFoundException {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isEmpty())
            throw new ClassNotFoundException("Such Address Id Not Found");

        return optionalAddress.get();
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public String deleteById(Long id) {
        addressRepository.deleteById(id);
        return "Successfully Deleted";
    }

    @Override
    public Address editById(Long id, AddressDto dto) throws ClassNotFoundException {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isEmpty())
            throw new ClassNotFoundException("This Address Id Not Found");
        Address address = optionalAddress.get();

        if (!(address.getName().equals(dto.getName())))
            address.setName(dto.getName());

        addressRepository.save(address);

        return addressRepository.save(address);
    }
}

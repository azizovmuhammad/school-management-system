package com.example.schoolmanagementsystem.controller;

import com.example.schoolmanagementsystem.dto.AddressDto;
import com.example.schoolmanagementsystem.entity.Address;
import com.example.schoolmanagementsystem.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;


    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/save")
    public Address save(@RequestBody AddressDto dto){
        return addressService.save(dto);
    }

    @GetMapping("/{id}")
    public Address findById(@PathVariable Long id) throws ClassNotFoundException {
        return addressService.findById(id);
    }

    @GetMapping("/all")
    public List<Address> findAll(){
        return addressService.findAll();
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        return addressService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Address editById(@PathVariable Long id, @RequestBody AddressDto dto) throws ClassNotFoundException {
        return addressService.editById(id,dto);
    }
}

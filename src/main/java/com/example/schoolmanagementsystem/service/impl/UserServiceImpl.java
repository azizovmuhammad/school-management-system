package com.example.schoolmanagementsystem.service.impl;

import com.example.schoolmanagementsystem.dto.UserCreateDto;
import com.example.schoolmanagementsystem.entity.Address;
import com.example.schoolmanagementsystem.entity.Role;
import com.example.schoolmanagementsystem.entity.School;
import com.example.schoolmanagementsystem.entity.User;
import com.example.schoolmanagementsystem.repository.AddressRepository;
import com.example.schoolmanagementsystem.repository.RoleRepository;
import com.example.schoolmanagementsystem.repository.SchoolRepository;
import com.example.schoolmanagementsystem.repository.UserRepository;
import com.example.schoolmanagementsystem.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AddressRepository addressRepository;
    private final SchoolRepository schoolRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, AddressRepository addressRepository, SchoolRepository schoolRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.addressRepository = addressRepository;
        this.schoolRepository = schoolRepository;
    }

    @Override
    public User save(UserCreateDto dto) throws ClassNotFoundException {

        //Role ID
        Long roleId = dto.getRoleId();
        Optional<Role> optionalRole = roleRepository.findById(roleId);

        if (optionalRole.isEmpty())
            throw new ClassNotFoundException("Such Role Id Not Fount");
        Role role = optionalRole.get();

        // Address ID
        Long addressId = dto.getAddressId();
        Optional<Address> optionalAddress = addressRepository.findById(addressId);

        if (optionalAddress.isEmpty())
            throw new ClassNotFoundException("Such Address Id Not Fount");
        Address address = optionalAddress.get();

        //School ID
        Long schoolId = dto.getSchoolId();
        Optional<School> optionalSchool = schoolRepository.findById(schoolId);

        if (optionalSchool.isEmpty())
            throw new ClassNotFoundException("Such School Id Not Found");
        School school = optionalSchool.get();


       User user = new User(
               dto.getName(),
               dto.getEmail(),
               role,
               address,
               school
       );
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long userId) throws ClassNotFoundException {

        Optional<User> findById = userRepository.findById(userId);
        if (findById.isEmpty())
            throw new ClassNotFoundException("Such User Id Not Found");
        return findById.get();
    }

    @Override
    public User editUser(Long userId, UserCreateDto dto) throws ClassNotFoundException {

        //Check User
        Optional<User> byId = userRepository.findById(userId);
        if (byId.isEmpty())
            throw new ClassNotFoundException("Such User Id Not Found");
        User user = byId.get();

        //Check Address
        Optional<Address> addressId = addressRepository.findById(dto.getAddressId());

        if (addressId.isEmpty())
            throw new ClassNotFoundException("Such Address Id Not Fount");
        Address address = addressId.get();

        //Check Role
        Optional<Role> roleId = roleRepository.findById(dto.getRoleId());

        if (roleId.isEmpty())
            throw new ClassNotFoundException("Such Role Id Not Fount");
        Role role = roleId.get();

        //Check School
        Optional<School> schoolId = schoolRepository.findById(dto.getSchoolId());

        if (schoolId.isEmpty())
            throw new ClassNotFoundException("Such School Id Not Fount");
        School school = schoolId.get();

        if (!(user.getName().equals(dto.getName())))
            user.setName(dto.getName());

        if (!(user.getEmail().equals(dto.getEmail())))
            user.setEmail(dto.getEmail());

        if (!user.getAddress().getId().equals(dto.getAddressId()))
            user.setAddress(address);


        if (!user.getRole().getId().equals(dto.getRoleId()))
            user.setRole(role);


        if (!user.getSchool().getId().equals(dto.getSchoolId()))
            user.setSchool(school);


        return userRepository.save(user);
    }

}

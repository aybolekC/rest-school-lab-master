package com.aya.controller;


import com.aya.dto.AddressDTO;
import com.aya.dto.ResponseWrapper;
import com.aya.dto.StudentDTO;
import com.aya.dto.TeacherDTO;
import com.aya.service.AddressService;
import com.aya.service.ParentService;
import com.aya.service.StudentService;
import com.aya.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {



    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService parentService;
    private final AddressService addressService;


    public ApiController(TeacherService teacherService, StudentService studentService, ParentService parentService, AddressService addressService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.parentService = parentService;
        this.addressService = addressService;
    }

    @GetMapping("/teachers")
    public List<TeacherDTO> readAllTeachers(){

        return teacherService.findAll();

    }

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> readAllStudents(){

        return ResponseEntity.ok(new ResponseWrapper("Students are successfully retrieved",studentService.findAll()));

    }


    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> readAllParents(){

        ResponseWrapper response=
                new ResponseWrapper(true,"Parents are successfully retrieved", HttpStatus.OK.value(), parentService.findAll());

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @GetMapping("/address/{id}")
    public ResponseEntity<ResponseWrapper> getAddress(@PathVariable("id")Long id) throws Exception {

        AddressDTO addressToReturn=addressService.findById(id);

        addressToReturn.setCurrentTemperature(addressService.getCurrentWeather(addressToReturn.getCity()).getCurrent().getTemperature());

        return ResponseEntity.ok(new ResponseWrapper("Address is successfully retrieved",addressToReturn));

    }

    @PutMapping("/address/{id}")
    public AddressDTO updateAddress(@PathVariable("id")Long id,
                                                         @RequestBody AddressDTO addressDTO) throws Exception {

        addressDTO.setId(id);

        AddressDTO addressToReturn=addressService.update(addressDTO);

        addressToReturn.setCurrentTemperature(addressService.getCurrentWeather(addressToReturn.getCity()).getCurrent().getTemperature());


        return addressToReturn;
    }

    @GetMapping("/addresses")
    public ResponseEntity<ResponseWrapper> readAllAddresses(){

        ResponseWrapper response=
                new ResponseWrapper(true,"Addresses are successfully retrieved", HttpStatus.OK.value(), addressService.findAll());

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }



}

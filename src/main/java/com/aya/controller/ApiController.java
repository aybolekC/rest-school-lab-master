package com.aya.controller;


import com.aya.dto.ResponseWrapper;
import com.aya.dto.StudentDTO;
import com.aya.dto.TeacherDTO;
import com.aya.service.StudentService;
import com.aya.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    private final TeacherService teacherService;
    private final StudentService studentService;


    public ApiController(TeacherService teacherService, StudentService studentService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    @GetMapping("/teachers")
    public List<TeacherDTO> readAllTeachers(){

        return teacherService.findAll();

    }

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> readAllStudents(){

        return ResponseEntity.ok(new ResponseWrapper("test",studentService.findAll()));

    }

}

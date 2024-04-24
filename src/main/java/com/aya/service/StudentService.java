package com.aya.service;

import com.aya.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    List<StudentDTO> findAll();

    StudentDTO findById(Long id) throws Exception;

}

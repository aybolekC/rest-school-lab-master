package com.aya.service;

import com.aya.dto.CourseDTO;

import java.util.List;

public interface CourseService {

    List<CourseDTO> findAll();

    CourseDTO findById(Long id) throws Exception;

}

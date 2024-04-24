package com.aya.service;

import com.aya.dto.ClassDTO;

import java.util.List;

public interface ClassService {

    List<ClassDTO> findAll();

    ClassDTO findById(Long id) throws Exception;

}

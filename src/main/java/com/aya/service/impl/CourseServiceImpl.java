package com.aya.service.impl;

import com.aya.dto.CourseDTO;
import com.aya.entity.Course;
import com.aya.mapper.MapperUtil;
import com.aya.repository.CourseRepository;
import com.aya.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final MapperUtil mapperUtil;

    public CourseServiceImpl(CourseRepository courseRepository, MapperUtil mapperUtil) {
        this.courseRepository = courseRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<CourseDTO> findAll() {
        return courseRepository.findAll()
                .stream()
                .map(course -> mapperUtil.convert(course,new CourseDTO()))
                .collect(Collectors.toList());

    }

    @Override
    public CourseDTO findById(Long id) throws Exception {
        Course foundCourse = courseRepository.findById(id)
                .orElseThrow(() -> new Exception("No Course Found!"));
        return mapperUtil.convert(foundCourse, new CourseDTO());

    }

}

package com.student.management.service;

import com.student.management.dto.CourseDTO;
import java.util.List;

public interface CourseService {
    CourseDTO uploadCourse(CourseDTO courseDTO);
    List<CourseDTO> getCoursesByStudent(Long studentId);
    void assignCourseToStudent(Long studentId, Long courseId);
    void removeCourseFromStudent(Long studentId, Long courseId);
}
package com.student.management.controller;

import com.student.management.dto.CourseDTO;
import com.student.management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public CourseDTO uploadCourse(@RequestBody CourseDTO courseDTO) {
        return courseService.uploadCourse(courseDTO);
    }

    @GetMapping("/student/{studentId}")
    public List<CourseDTO> getCoursesByStudent(@PathVariable Long studentId) {
        return courseService.getCoursesByStudent(studentId);
    }

    @PostMapping("/assign")
    public void assignCourseToStudent(@RequestParam Long studentId, @RequestParam Long courseId) {
        courseService.assignCourseToStudent(studentId, courseId);
    }

    @PostMapping("/remove")
    public void removeCourseFromStudent(@RequestParam Long studentId, @RequestParam Long courseId) {
        courseService.removeCourseFromStudent(studentId, courseId);
    }
}
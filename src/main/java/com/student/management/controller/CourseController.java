package com.student.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.entity.Course;
import com.student.management.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public Course uploadCourse(@RequestBody Course course) {
        return courseService.uploadCourse(course);
    }

    @GetMapping("/student/{studentId}")
    public List<Course> getCoursesByStudent(@PathVariable Long studentId) {
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
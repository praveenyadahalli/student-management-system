package com.student.management.service;

import java.util.List;

import com.student.management.entity.Course;

public interface CourseService {
    Course uploadCourse(Course course);
    List<Course> getCoursesByStudent(Long studentId);
    void assignCourseToStudent(Long studentId, Long courseId);
    void removeCourseFromStudent(Long studentId, Long courseId);
}
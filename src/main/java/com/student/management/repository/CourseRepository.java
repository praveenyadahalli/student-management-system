package com.student.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.management.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    // Find courses by student ID
    List<Course> findByStudents_Id(Long studentId);
}
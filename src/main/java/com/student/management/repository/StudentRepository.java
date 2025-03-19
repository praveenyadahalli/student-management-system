package com.student.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.management.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Find students by name (partial match)
    List<Student> findByNameContaining(String name);

    // Find students by course ID
    List<Student> findByCourses_Id(Long courseId);
}
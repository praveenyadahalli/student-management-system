package com.student.management.service;

import java.util.List;

import com.student.management.entity.Student;

public interface StudentService {
    Student admitStudent(Student student);
    List<Student> getStudentsByName(String name);
    Student updateStudentProfile(Long id, Student updatedStudent);
    List<Student> getStudentsByCourse(Long courseId);
}
package com.student.management.service;

import com.student.management.dto.StudentDTO;
import java.util.List;

public interface StudentService {
    StudentDTO admitStudent(StudentDTO studentDTO);
    List<StudentDTO> getStudentsByName(String name);
    StudentDTO updateStudentProfile(Long id, StudentDTO updatedStudent);
    List<StudentDTO> getStudentsByCourse(Long courseId);
}
package com.student.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.entity.Student;
import com.student.management.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student admitStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudentsByName(String name) {
        return studentRepository.findByNameContaining(name);
    }

    @Override
    public Student updateStudentProfile(Long id, Student updatedStudent) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        student.setEmail(updatedStudent.getEmail());
        student.setMobileNumber(updatedStudent.getMobileNumber());
        student.setParentsName(updatedStudent.getParentsName());
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudentsByCourse(Long courseId) {
        return studentRepository.findByCourses_Id(courseId);
    }
}

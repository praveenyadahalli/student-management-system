package com.student.management.service;

import com.student.management.dto.StudentDTO;
import com.student.management.entity.Student;
import com.student.management.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentDTO admitStudent(StudentDTO studentDTO) {
        // Convert DTO to Entity
        Student student = modelMapper.map(studentDTO, Student.class);

        // Save the entity
        Student savedStudent = studentRepository.save(student);

        // Convert Entity back to DTO
        return modelMapper.map(savedStudent, StudentDTO.class);
    }

    @Override
    public List<StudentDTO> getStudentsByName(String name) {
        List<Student> students = studentRepository.findByNameContaining(name);
        return students.stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO updateStudentProfile(Long id, StudentDTO updatedStudent) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // Update fields
        student.setEmail(updatedStudent.getEmail());
        student.setMobileNumber(updatedStudent.getMobileNumber());
        student.setParentsName(updatedStudent.getParentsName());

        // Save the updated entity
        Student savedStudent = studentRepository.save(student);

        // Convert Entity back to DTO
        return modelMapper.map(savedStudent, StudentDTO.class);
    }

    @Override
    public List<StudentDTO> getStudentsByCourse(Long courseId) {
        List<Student> students = studentRepository.findByCourses_Id(courseId);
        return students.stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }
}
package com.student.management.service;

import com.student.management.dto.CourseDTO;
import com.student.management.entity.Course;
import com.student.management.entity.Student;
import com.student.management.repository.CourseRepository;
import com.student.management.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CourseDTO uploadCourse(CourseDTO courseDTO) {
        // Convert DTO to Entity
        Course course = modelMapper.map(courseDTO, Course.class);

        // Save the entity
        Course savedCourse = courseRepository.save(course);

        // Convert Entity back to DTO
        return modelMapper.map(savedCourse, CourseDTO.class);
    }

    @Override
    public List<CourseDTO> getCoursesByStudent(Long studentId) {
        List<Course> courses = courseRepository.findByStudents_Id(studentId);
        return courses.stream()
                .map(course -> modelMapper.map(course, CourseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void assignCourseToStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        student.getCourses().add(course);
        studentRepository.save(student);
    }

    @Override
    public void removeCourseFromStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        student.getCourses().remove(course);
        studentRepository.save(student);
    }
}
package com.student.management.controller;

import com.student.management.dto.StudentDTO;
import com.student.management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public StudentDTO admitStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.admitStudent(studentDTO);
    }

    @GetMapping("/search")
    public List<StudentDTO> getStudentsByName(@RequestParam String name) {
        return studentService.getStudentsByName(name);
    }

    @PutMapping("/{id}")
    public StudentDTO updateStudentProfile(@PathVariable Long id, @RequestBody StudentDTO updatedStudent) {
        return studentService.updateStudentProfile(id, updatedStudent);
    }

    @GetMapping("/course/{courseId}")
    public List<StudentDTO> getStudentsByCourse(@PathVariable Long courseId) {
        return studentService.getStudentsByCourse(courseId);
    }
}
package com.student.management.helper;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StudentHelper {

    /**
     * Generates a unique student code.
     *
     * @return A unique student code in the format "STU-<random UUID>".
     */
    public String generateUniqueStudentCode() {
        return "STU-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
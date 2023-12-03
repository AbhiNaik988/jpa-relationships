package com.abhinaik.datajpa.service;

import com.abhinaik.datajpa.models.Student;

import java.util.List;

public interface StudentService {
    void addAllStudents(List<Student> studentList);
    Student getStudentByName(String studentName);
    void deleteStudent(Long studentId);
}

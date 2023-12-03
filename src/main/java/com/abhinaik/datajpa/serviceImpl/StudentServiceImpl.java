package com.abhinaik.datajpa.serviceImpl;

import com.abhinaik.datajpa.models.Student;
import com.abhinaik.datajpa.repository.StudentRepository;
import com.abhinaik.datajpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public void addAllStudents(List<Student> studentList) {
        this.studentRepository.saveAll((studentList));
    }

    @Override
    public Student getStudentByName(String studentName) {
        return this.studentRepository.findByName(studentName);
    }


    @Override
    public void deleteStudent(Long studentId) {
        this.studentRepository.deleteById(studentId);
    }

}

package com.abhinaik.datajpa.serviceImpl;

import com.abhinaik.datajpa.models.Teacher;
import com.abhinaik.datajpa.repository.TeacherRepository;
import com.abhinaik.datajpa.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;

    @Autowired
    public void setTeacherRepository(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void addAllTeachers(List<Teacher> teacherList) {
        this.teacherRepository.saveAll(teacherList);
    }
}

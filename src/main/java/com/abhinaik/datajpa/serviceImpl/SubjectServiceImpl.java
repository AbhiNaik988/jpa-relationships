package com.abhinaik.datajpa.serviceImpl;

import com.abhinaik.datajpa.models.Subject;
import com.abhinaik.datajpa.repository.SubjectRepository;
import com.abhinaik.datajpa.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private SubjectRepository subjectRepository;

    @Autowired
    public void setSubjectRepository(SubjectRepository subjectRepository){
        this.subjectRepository = subjectRepository;
    }

    @Override
    public void addAllSubjects(List<Subject> subjectList) {
        this.subjectRepository.saveAll(subjectList);
    }
}

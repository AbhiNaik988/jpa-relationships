package com.abhinaik.datajpa.configuration;

import com.abhinaik.datajpa.models.Student;
import com.abhinaik.datajpa.models.Subject;
import com.abhinaik.datajpa.models.Tablet;
import com.abhinaik.datajpa.models.Teacher;
import com.abhinaik.datajpa.service.StudentService;
import com.abhinaik.datajpa.service.SubjectService;
import com.abhinaik.datajpa.service.TabletService;
import com.abhinaik.datajpa.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MappingsConfig implements CommandLineRunner {

    private StudentService studentService;
    private TabletService tabletService;

    private SubjectService subjectService;

    private TeacherService teacherService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setTabletService(TabletService tabletService) {
        this.tabletService = tabletService;
    }

    @Autowired
    public void setSubjectService(SubjectService subjectService){
        this.subjectService = subjectService;
    }

    @Autowired
    public void setTeacherService(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @Override
    public void run(String... args) throws Exception {

        //Add Students
        Student abhi = Student.builder().name("abhi").build();
        Student abhay = Student.builder().name("abhay").build();
        Student dev = Student.builder().name("dev").build();
        Student sunny = Student.builder().name("sunny").build();
        this.studentService.addAllStudents(List.of(abhi, abhay, dev, sunny));


        //Add Tablets where tablets mapped with students with one to one mapping
        Tablet dell = Tablet.builder().brand("Dell").student(abhi).build();
        Tablet htc = Tablet.builder().brand("Htc").student(abhay).build();
        Tablet samsung = Tablet.builder().brand("Samsung").student(dev).build();
        Tablet mi = Tablet.builder().brand("Mi").student(sunny).build();
        this.tabletService.addAllTablets(List.of(dell, htc, samsung, mi));

        //delete one student
        this.studentService.deleteStudent(this.studentService.getStudentByName("abhay").getId());

        //add all subjects
        Subject maths = Subject.builder().name("maths").student(abhi).build();
        Subject science = Subject.builder().name("science").student(abhi).build();
        Subject english = Subject.builder().name("english").student(abhi).build();
        this.subjectService.addAllSubjects(List.of(maths,science,english));

        //add all Teachers
        Teacher paresh = Teacher.builder().name("paresh").studentList(List.of(abhi, dev)).build();
        Teacher ramesh = Teacher.builder().name("ramesh").studentList(List.of(dev,abhi,sunny)).build();
        this.teacherService.addAllTeachers(List.of(paresh,ramesh));
    }
}

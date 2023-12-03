package com.abhinaik.datajpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private Tablet tablet;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Subject> subjectList = new ArrayList<>();

    @ManyToMany(mappedBy = "studentList",cascade = CascadeType.ALL)
    private List<Teacher> teacherList = new ArrayList<>();
}

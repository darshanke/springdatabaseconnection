package com.jdbcspring.SpringJDBCExample.service;


import com.jdbcspring.SpringJDBCExample.model.Student;
import com.jdbcspring.SpringJDBCExample.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    private StudentRepo repo;
    public StudentRepo getRepo() {

        return repo;
    }


    @Autowired
    public void setRepo(StudentRepo repo) {
//        System.out.println("setting repo");
        this.repo = repo;
    }


    public void addStudent(Student s){

       repo.save(s);
    }

    public List<Student> getStudents(){
        return repo.findAll();
    }
}

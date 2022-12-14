package com.example.springboot_collegelibrary.repository;

import com.example.springboot_collegelibrary.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class StudentRepository {

    @Autowired
    StudentMapper studentMapper;


    public HashMap<String,String> selectStudentByEmail(String studentEmail){
        return studentMapper.selectStudentByEmail(studentEmail);
    }

    public int studentSignUp(HashMap<String,String> newStudent){
        return studentMapper.studentSignUp(newStudent);
    }
}

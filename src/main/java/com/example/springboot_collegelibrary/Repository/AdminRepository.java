package com.example.springboot_collegelibrary.Repository;


import com.example.springboot_collegelibrary.entity.StudentTableEntity;
import com.example.springboot_collegelibrary.mapper.AdminCommandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class AdminRepository {

    @Autowired
    AdminCommandMapper adminCommandMapper;

    public ArrayList<StudentTableEntity> getAllStudents(){
        return adminCommandMapper.getAllStudents();
    }
    public ArrayList<StudentTableEntity> searchStudentByKeyword(String keyword){
        return adminCommandMapper.searchStudentByKeyword(keyword);
    }
    public int deleteStudentByStudentEmail(String studentEmail){
        return adminCommandMapper.deleteStudentByStudentEmail(studentEmail);
    }

}

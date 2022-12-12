package com.example.springboot_collegelibrary.Service;

import com.example.springboot_collegelibrary.Repository.AdminRepository;
import com.example.springboot_collegelibrary.entity.StudentTableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public ArrayList<StudentTableEntity> getAllStudents(){
        return adminRepository.getAllStudents();
    }
    public ArrayList<StudentTableEntity> searchStudentByKeyword(String keyword){
        return adminRepository.searchStudentByKeyword(keyword);
    }
    public int deleteStudentByStudentEmail(String studentEmail){
        return adminRepository.deleteStudentByStudentEmail(studentEmail);
    }
}

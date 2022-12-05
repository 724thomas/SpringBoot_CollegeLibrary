package com.example.springboot_collegelibrary.Service;


import com.example.springboot_collegelibrary.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public boolean duplicateEmail(String email){
        if (studentRepository.selectStudentByEmail(email)!=null){
            return true;
        }
        return false;
    }

    public boolean correctEmailOrPassword(String email, String password){
        HashMap<String, String> tempHash = studentRepository.selectStudentByEmail(email);
        if (tempHash==null){
            return false;
        }
        if (tempHash.get("studentEmail").equals(email) && tempHash.get("studentPassword").equals(password)){
            System.out.println("StudentService.correctEmailOrPassword : 로그인 성공");
            return true;
        }
        System.out.println("StudentService.correctEmailOrPassword : 로그인 실패");
        return false;
    }

    public boolean studentSignUp(HashMap<String, String> newStudent){
        if (!duplicateEmail(newStudent.get("studentEmail"))){
            System.out.println("StudentService.studentSignUp : 회원가입 완료");
            studentRepository.studentSignUp(newStudent);
            return true;
        }
        System.out.println("StudentService.studentSignUp : 회원가입 실패. 중복 아이디");
        return false;
    }
}

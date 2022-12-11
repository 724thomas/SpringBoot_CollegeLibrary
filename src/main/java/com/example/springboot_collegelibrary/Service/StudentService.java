package com.example.springboot_collegelibrary.Service;


import com.example.springboot_collegelibrary.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public boolean isEmailDuplicate(String email){
        if (studentRepository.selectStudentByEmail(email)!=null){
            return true;
        }
        return false;
    }

    public boolean correctEmailOrPasswordA(String email, String password){
        HashMap<String,String> selectedStudentEntity = studentRepository.selectStudentByEmail(email);
        if (selectedStudentEntity==null){
            System.out.println("StudentService.correctEmailOrPassword : User not found");
            return false;
        }
        else if (selectedStudentEntity.get("studentEmail").equals(email) && selectedStudentEntity.get("studentPassword").equals(password)){
            System.out.println("StudentService.correctEmailOrPassword : Correct Email and Password.");
            return true;
        }
        else{
            System.out.println("StudentService.correctEmailOrPassword :  Wrong Email and Password.");
            return false;
        }
    }


    public boolean studentSignUp(HashMap<String,String> student){
        if (!isEmailDuplicate(student.get("studentEmail"))){
            System.out.println("StudentService.studentSignUp : 회원가입 완료");
            studentRepository.studentSignUp(student);
            return true;
        }
        System.out.println("StudentService.studentSignUp : 회원가입 실패. 중복 아이디");
        return false;
    }
}

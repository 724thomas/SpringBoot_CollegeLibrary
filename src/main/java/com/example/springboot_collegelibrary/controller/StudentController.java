package com.example.springboot_collegelibrary.controller;

import com.example.springboot_collegelibrary.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    //[studentNumber, studentEmail, studentPassword, studentName, studentPhone, Terms, Submit]
    //[asd, asd@asd, asd, asd, asd, on, 등록하기]

    @PostMapping("/")
    public String login(@RequestParam String studentEmail, String studentPassword){
        if(studentService.correctEmailOrPassword(studentEmail,studentPassword)){
            System.out.println("성공");
        }
        System.out.println("실패");
        return "redirect:/";
    }


    @PostMapping("/signup")
    public String signup(@RequestParam HashMap<String, String> student){

        studentService.studentSignUp(student);
        return "redirect:/";
    }
}

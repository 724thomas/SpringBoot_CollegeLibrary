package com.example.springboot_collegelibrary.controller;

import com.example.springboot_collegelibrary.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    //[studentNumber, studentEmail, studentPassword, studentName, studentPhone, Terms, Submit]
    //[asd, asd@asd, asd, asd, asd, on, 등록하기]

    @PostMapping("/")
    public String login(@RequestParam String studentEmail, String studentPassword, HttpSession session){
        if (session.getAttribute("email")!=null){
            return "redirect:/searchPage";
        }
        if(studentService.correctEmailOrPassword(studentEmail,studentPassword)){
            System.out.println("StudentController.login : 로그인 성공");
            session.setAttribute("email",studentEmail);
            return "redirect:/searchPage";
        }
        System.out.println("실패");
        return "redirect:/login";
    }


    @PostMapping("/signup")
    public String signup(@RequestParam HashMap<String, String> student) {
        studentService.studentSignUp(student);
        return "redirect:/";
    }
}

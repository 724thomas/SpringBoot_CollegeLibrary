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

    @PostMapping("/")
    public String login(@RequestParam String studentEmail, String studentPassword, HttpSession session){
        if (session.getAttribute("email")!=null){
            return "redirect:/searchPage";
        }
        if(studentService.correctEmailOrPassword(studentEmail,studentPassword)){ //
            System.out.println("StudentController.login : Login Success");
            session.setAttribute("email",studentEmail);
            System.out.println("StudentController.login : Redirecting to searchPage");
            return "redirect:/searchPage";
        }
        System.out.println("StudentController.login : Login Failed. Redirecting to loginPage");
        return "redirect:/login";
    }


    @PostMapping("/signup")
    public String signup(@RequestParam HashMap<String, String> student) {
        if (studentService.studentSignUp(student)){
            System.out.println("StudentController.signup : Signup Successful. Redirecting to loginPage");
            return "redirect:/";
        }else{
            System.out.println("StudentController.signup : Signup Failed. Redirecting to Signup Page");
            return "redirect:/signup";
        }
    }
}

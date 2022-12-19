package com.example.springboot_collegelibrary.controller.student;

import com.example.springboot_collegelibrary.service.StudentService;
import com.example.springboot_collegelibrary.aop.SkipLoginCheck;
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

    @SkipLoginCheck
    @PostMapping("/")
    public String login(@RequestParam String studentEmail, String studentPassword, HttpSession session){
        if (studentEmail.equals("admin@admin")){
            session.setAttribute("email",studentEmail);
            return "redirect:/admin/adminMenu";
        }
        if (session.getAttribute("email")!=null){
            return "redirect:/searchPage";
        }
        if(studentService.correctEmailOrPasswordA(studentEmail,studentPassword)){ //
            session.setAttribute("email",studentEmail);
            return "redirect:/searchPage";
        }
        return "redirect:/login";
    }

    @SkipLoginCheck
    @PostMapping("/signup")
    public String signup(@RequestParam HashMap<String, String> student) {
        if (studentService.studentSignUp(student)){
            return "redirect:/";
        }else{
            return "redirect:/signup";
        }
    }
}

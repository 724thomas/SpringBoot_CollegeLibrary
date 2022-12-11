package com.example.springboot_collegelibrary.controller;

import com.example.springboot_collegelibrary.Service.StudentHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class StudentHistoryController {

    @Autowired
    StudentHistoryService studentHistoryService;

    @GetMapping("/studentHistory")
    public String studentHistory(Model model, HttpSession session){
        model.addAttribute("studentCurrentBorrowDTO",studentHistoryService.getStudentCurrentBorrowList((String)session.getAttribute("email")));
        model.addAttribute("studentHistoryDTO",studentHistoryService.getStudentBorrowedBookHistory((String)session.getAttribute("email")));
        return "studenthistory";
    }
}

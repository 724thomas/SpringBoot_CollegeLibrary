package com.example.springboot_collegelibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class StudentBookReturnController {
    @PostMapping("/studentBookReturn")
    public String borrowBook(@RequestParam String bookId, HttpSession session){
        return "redirect:/studentHistory";
    }
}

package com.example.springboot_collegelibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @GetMapping("/")
    public String login(HttpSession session){
        if (session.getAttribute("email")==null) {
            return "login";
        }
        return "search";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @GetMapping("/search")
    public String search(){
        return "search";
    }

    @GetMapping("/logout")
    public String search(HttpSession session){
        session.setAttribute("email",null);
        return "redirect:/";
    }
}

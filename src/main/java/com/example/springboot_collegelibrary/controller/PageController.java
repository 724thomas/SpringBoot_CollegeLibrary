package com.example.springboot_collegelibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @GetMapping("/")
    public String index(HttpSession session){
        if (session.getAttribute("email")==null) {
            return "login";
        }
        return "searchPage";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @GetMapping("/searchPage")
    public String search(){
        return "searchPage";
    }

    @GetMapping("/logout")
    public String search(HttpSession session){
        session.setAttribute("email",null);
        return "redirect:/";
    }
}

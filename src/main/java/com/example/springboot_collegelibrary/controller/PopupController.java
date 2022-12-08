package com.example.springboot_collegelibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class PopupController {

    @PostMapping("/instructionpopupclose")
    public String instructionPopUp(@RequestParam String check, HttpSession session){
        session.setAttribute("doNotShowInThisSession",true);
        return check;
    }
}

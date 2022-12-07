package com.example.springboot_collegelibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PopupController {

    @GetMapping("/instructionpopupclose")
    public String instructionPopUp(@RequestParam String close){
        System.out.println(close);
        return "instructionpopup";
    }
}
